package com.hpe.devops.gitmetrics.rest;

import com.hpe.devops.gitmetrics.dto.VersionDto;
import com.hpe.devops.gitmetrics.model.GitRepositoryState;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

@RestController
public class VersionRestController {

    @ResponseBody
    @RequestMapping("/version")
    public VersionDto getVersion() throws IOException, URISyntaxException{
        Properties gitProperties = new Properties();
        gitProperties.load(getClass().getClassLoader().getResourceAsStream("git.properties"));
        GitRepositoryState repositoryState = new GitRepositoryState(gitProperties);

        Properties applicationProperties = new Properties();
        applicationProperties.load(getClass().getClassLoader().getResourceAsStream("git.properties"));

        Date compilationDate = new Date(new File(getClass().getClassLoader().getResource(getClass().getCanonicalName().replace('.', '/') + ".class").toURI()).lastModified());
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        VersionDto versionDto = new VersionDto();

        versionDto.setCompilationDate(formatter.format(compilationDate));
        versionDto.setCommitId(repositoryState.getCommitId());
        versionDto.setCommiter(repositoryState.getCommitUserEmail());
        versionDto.setGitBranch(repositoryState.getBranch());
        versionDto.setVersion(repositoryState.getBuildVersion());

        return versionDto;
    }
}
