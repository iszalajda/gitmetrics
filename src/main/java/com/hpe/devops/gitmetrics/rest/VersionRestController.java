package com.hpe.devops.gitmetrics.rest;

import com.hpe.devops.gitmetrics.dto.VersionDto;
import com.hpe.devops.gitmetrics.model.GitRepositoryState;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;

@RestController
public class VersionRestController {

    @ResponseBody
    @RequestMapping("/version")
    public VersionDto getVersion() throws IOException{
        Properties gitProperties = new Properties();
        gitProperties.load(getClass().getClassLoader().getResourceAsStream("git.properties"));
        GitRepositoryState repositoryState = new GitRepositoryState(gitProperties);

        Properties applicationProperties = new Properties();
        applicationProperties.load(getClass().getClassLoader().getResourceAsStream("git.properties"));

        VersionDto versionDto = new VersionDto();

        versionDto.setCompilationDate(repositoryState.getBuildTime());
        versionDto.setCommitId(repositoryState.getCommitId());
        versionDto.setCommiter(repositoryState.getCommitUserEmail());
        versionDto.setGitBranch(repositoryState.getBranch());
        versionDto.setVersion(repositoryState.getBuildVersion());

        return versionDto;
    }
}
