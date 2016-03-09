package com.hpe.devops.gitmetrics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VersionDto {
    @JsonProperty("version")
    private String version;

    @JsonProperty("gitCommitId")
    private String commitId;

    @JsonProperty("gitBranch")
    private String gitBranch;

    @JsonProperty("compilationDate")
    private String compilationDate;

    @JsonProperty
    private String commiter;

    public String getCommiter() {
        return commiter;
    }

    public void setCommiter(String commiter) {
        this.commiter = commiter;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public String getCompilationDate() {
        return compilationDate;
    }

    public void setCompilationDate(String compilationDate) {
        this.compilationDate = compilationDate;
    }

    public String getGitBranch(){
        return gitBranch;
    }

    public void setGitBranch(String gitBranch){
        this.gitBranch = gitBranch;
    }
}
