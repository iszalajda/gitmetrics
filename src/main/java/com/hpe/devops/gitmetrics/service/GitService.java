package com.hpe.devops.gitmetrics.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand.ListMode;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hpe.devops.gitmetrics.dto.BranchDto;
import com.hpe.devops.gitmetrics.dto.CommitDto;

@Service
public class GitService {
	//podpiac loggera
	private static final Logger logger = LoggerFactory.getLogger(GitService.class);
	private static final ExecutorService executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
	
/*o the constructed basePath/directoryName
	 * Since the clone may be time and resources consuming it is best to execute it inside a {@link ThreadPoolExecutor}
	 * @param remoteUrl
	 * @param basePath
	 * @param directoryName
	 * @return Git object
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public Git clone(String remoteUrl,String basePath, String directoryName) throws InterruptedException, ExecutionException {
		Future<Git> clonedRepository = executor.submit(()->{
			File subdir = new File(getBasedir(basePath, "projects"), directoryName);
			Git result = Git.cloneRepository().setURI(remoteUrl).setDirectory(subdir).call();
			
			return result;
		});
		
		return clonedRepository.get();
	}
	
	/**
	 * Constructs and validates the File that will be used to clone projects
	 * @param parentPath
	 * @param projectsBaseDirName
	 * @return File of the basedir
	 */
	private File getBasedir(String parentPath, String projectsBaseDirName){
		Path basepath = Paths.get(parentPath, projectsBaseDirName);
		Path parent = basepath.getParent();
		if(Files.isReadable(parent) && Files.isWritable(parent)){
			File baseDir = basepath.toFile();
			if(!baseDir.exists()){
				baseDir.mkdirs();
			}
			return baseDir;
		} else {
			throw new IllegalArgumentException(String.format("You don't have permissions to read and write in %s%s", parentPath, projectsBaseDirName));
		}
	}
	private Git getGit(String basePath, String directoryName) {
		File subdir = new File(getBasedir(basePath, "projects"), directoryName);
		try (Git git = Git.open(subdir)) {
			if (git.getRepository().getObjectDatabase().exists()) {
				return git;
			} else {
				logger.debug("Provided ID is not a repository");
				throw new IllegalArgumentException("Provided ID is not a repository");
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<BranchDto> getBranchesList(String basePath, String directoryName) throws GitAPIException {
		List<Ref> call = this.getGit(basePath, directoryName).branchList().setListMode(ListMode.ALL).call();
		List<BranchDto> branchList = new ArrayList<BranchDto>();
		for (Ref ref : call) {
			branchList.add(new BranchDto(ref.getObjectId().getName(), ref.getName()));
		}
		return branchList;
	}
	
	public List<CommitDto> getCommitList (String branchDtoName, String basePath, String directoryName)throws GitAPIException, RevisionSyntaxException, MissingObjectException, IncorrectObjectTypeException, AmbiguousObjectException, IOException{
		Git git = this.getGit(basePath, directoryName);
		List<CommitDto> commitDtoList = new ArrayList<>();
		Iterable<RevCommit> call = git.log().add(git.getRepository().resolve(branchDtoName)).call();
		for(RevCommit commit: call){
			commitDtoList.add(new CommitDto(commit.getId().getName(),new Date (commit.getCommitTime()).toString(), commit.getCommitterIdent().getName(), commit.getCommitterIdent().getEmailAddress()));
		}
		return commitDtoList;
	}
}
