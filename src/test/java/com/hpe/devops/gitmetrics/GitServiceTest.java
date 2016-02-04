package com.hpe.devops.gitmetrics;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ExecutionException;

import org.eclipse.jgit.api.Git;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.hpe.devops.gitmetrics.service.GitService;

public class GitServiceTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private static final String REPOSITORY_URL = "https://github.com/naimpl/threadpoolexecutorexample.git";
	private static final String REPOSITORY_DIR = "threadpoolexecutorexample-junit";
	private GitService gitService = new GitService();

	@Test
	@Ignore
	public void testClone() throws InterruptedException, ExecutionException {
		Git git = this.gitService.clone(REPOSITORY_URL, "/Users/piotrek", REPOSITORY_DIR);
		assertThat(git, notNullValue());
		assertThat(git.getRepository().getObjectDatabase().exists(), is(true));
	}
	
	@Test
	@Ignore
	public void testCloneToRoot() throws InterruptedException, ExecutionException {
		exception.expect(ExecutionException.class);
		this.gitService.clone(REPOSITORY_URL, "/", REPOSITORY_DIR);
	}

}
