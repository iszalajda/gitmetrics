package com.hpe.devops.gitmetrics.rest;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.devops.gitmetrics.dto.BranchDto;
import com.hpe.devops.gitmetrics.dto.RepositoryDto;
import com.hpe.devops.gitmetrics.service.GitService;

@RestController
public class GitRestController {
	
	
	@Autowired
	private GitService gitService;
	
	private static final String BASE_DIR = "C:\\git";
	
	@ResponseBody
	@RequestMapping(path = "/repositories/test")
	public String test(){
		return "ok";
	}
	
	@ResponseBody 
	@RequestMapping(path = "/repositories/clone", method = RequestMethod.POST)
	public RepositoryDto clone(@RequestBody RepositoryDto input) throws InterruptedException, ExecutionException{
		
		Git clonnedRepo = this.gitService.clone(input.getUrl(), BASE_DIR, input.getName());
		System.out.println(clonnedRepo.getRepository());
		return new RepositoryDto(clonnedRepo.getRepository().getDirectory().getName(), clonnedRepo.getRepository().getConfig().getString("remote","origin","url"));
	}

	@ResponseBody 
	@RequestMapping(path = "/repositories/{directoryName}/branches", method = RequestMethod.GET)
	public List <BranchDto> getBranches(@PathVariable String directoryName) throws GitAPIException{
		return this.gitService.getBranchesList(BASE_DIR, directoryName);
	}
	
}
