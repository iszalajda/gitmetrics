package com.hpe.devops.gitmetrics.rest;

import com.hpe.devops.gitmetrics.dto.BranchDto;
import com.hpe.devops.gitmetrics.dto.CommitDto;
import com.hpe.devops.gitmetrics.dto.RepositoryDto;
import com.hpe.devops.gitmetrics.service.GitService;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class GitRestController {
	
	
	@Autowired
	private GitService gitService;

	@Value("${git.clone.directory}")
	private String gitCloneDirectory;
	
	@ResponseBody
	@RequestMapping(value = "/repositories/test")
	public String test(){
		return "ok";
	}
	
	@ResponseBody 
	@RequestMapping(value = "/repositories/clone", method = RequestMethod.POST)
	public RepositoryDto clone(@RequestBody RepositoryDto input) throws InterruptedException, ExecutionException{
		
		Git clonnedRepo = this.gitService.clone(input.getUrl(), gitCloneDirectory, input.getName());
		System.out.println(clonnedRepo.getRepository());
		return new RepositoryDto(clonnedRepo.getRepository().getDirectory().getName(), clonnedRepo.getRepository().getConfig().getString("remote","origin","url"));
	}
	

	@ResponseBody 
	@RequestMapping(value = "/repositories/{directoryName}/branches", method = RequestMethod.GET)
	public List <BranchDto> getBranches(@PathVariable String directoryName) throws GitAPIException{
		return this.gitService.getBranchesList(gitCloneDirectory, directoryName);
	}

	@ResponseBody
	@RequestMapping(value = "/gui/repositories/{directoryName}/branches", method = RequestMethod.GET)
	public ModelAndView getBranchesWithGUI(@PathVariable String directoryName, ModelAndView mav) throws GitAPIException {
		mav.setViewName("branchesList");
		mav.addObject("branches", this.gitService.getBranchesList(gitCloneDirectory, directoryName));
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/repositories/{directoryName}/branches/{branchName}/commits", method = RequestMethod.GET)
	public List <CommitDto> getCommits (@PathVariable String branchName, @PathVariable String directoryName) throws RevisionSyntaxException, MissingObjectException, IncorrectObjectTypeException, AmbiguousObjectException, GitAPIException, IOException{
		return this.gitService.getCommitList(branchName, gitCloneDirectory, directoryName);
	}
	
	
	
}
