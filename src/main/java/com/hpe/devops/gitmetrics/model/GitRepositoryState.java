package com.hpe.devops.gitmetrics.model;

import java.io.IOException;
import java.util.Properties;

public class GitRepositoryState {

    String tags;                    // =${git.tags} // comma separated tag names
    String branch;                  // =${git.branch}
    String dirty;                   // =${git.dirty}
    String remoteOriginUrl;         // =${git.remote.origin.url}

    String commitId;                // =${git.commit.id.full} OR ${git.commit.id}
    String commitIdAbbrev;          // =${git.commit.id.abbrev}
    String describe;                // =${git.commit.id.describe}
    String describeShort;           // =${git.commit.id.describe-short}
    String commitUserName;          // =${git.commit.user.name}
    String commitUserEmail;         // =${git.commit.user.email}
    String commitMessageFull;       // =${git.commit.message.full}
    String commitMessageShort;      // =${git.commit.message.short}
    String commitTime;              // =${git.commit.time}
    String closestTagName;          // =${git.closest.tag.name}
    String closestTagCommitCount;   // =${git.closest.tag.commit.count}

    String buildUserName;           // =${git.build.user.name}
    String buildUserEmail;          // =${git.build.user.email}
    String buildTime;               // =${git.build.time}
    String buildHost;               // =${git.build.host}
    String buildVersion;            // =${git.build.version}

    public GitRepositoryState(Properties properties){
        this.tags = String.valueOf(properties.get("git.tags"));
        this.branch = String.valueOf(properties.get("git.branch"));
        this.dirty = String.valueOf(properties.get("git.dirty"));
        this.remoteOriginUrl = String.valueOf(properties.get("git.remote.origin.url"));
        this.commitId = String.valueOf(properties.get("git.commit.id.full")); // OR properties.get("git.commit.id") depending on your configuration
        this.commitIdAbbrev = String.valueOf(properties.get("git.commit.id.abbrev"));
        this.describe = String.valueOf(properties.get("git.commit.id.describe"));
        this.describeShort = String.valueOf(properties.get("git.commit.id.describe-short"));
        this.commitUserName = String.valueOf(properties.get("git.commit.user.name"));
        this.commitUserEmail = String.valueOf(properties.get("git.commit.user.email"));
        this.commitMessageFull = String.valueOf(properties.get("git.commit.message.full"));
        this.commitMessageShort = String.valueOf(properties.get("git.commit.message.short"));
        this.commitTime = String.valueOf(properties.get("git.commit.time"));
        this.closestTagName = String.valueOf(properties.get("git.closest.tag.name"));
        this.closestTagCommitCount = String.valueOf(properties.get("git.closest.tag.commit.count"));
        this.buildUserName = String.valueOf(properties.get("git.build.user.name"));
        this.buildUserEmail = String.valueOf(properties.get("git.build.user.email"));
        this.buildTime = String.valueOf(properties.get("git.build.time"));
        this.buildHost = String.valueOf(properties.get("git.build.host"));
        this.buildVersion = String.valueOf(properties.get("git.build.version"));
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getRemoteOriginUrl() {
        return remoteOriginUrl;
    }

    public void setRemoteOriginUrl(String remoteOriginUrl) {
        this.remoteOriginUrl = remoteOriginUrl;
    }

    public String getDirty() {
        return dirty;
    }

    public void setDirty(String dirty) {
        this.dirty = dirty;
    }

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public String getCommitIdAbbrev() {
        return commitIdAbbrev;
    }

    public void setCommitIdAbbrev(String commitIdAbbrev) {
        this.commitIdAbbrev = commitIdAbbrev;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDescribeShort() {
        return describeShort;
    }

    public void setDescribeShort(String describeShort) {
        this.describeShort = describeShort;
    }

    public String getCommitUserName() {
        return commitUserName;
    }

    public void setCommitUserName(String commitUserName) {
        this.commitUserName = commitUserName;
    }

    public String getCommitUserEmail() {
        return commitUserEmail;
    }

    public void setCommitUserEmail(String commitUserEmail) {
        this.commitUserEmail = commitUserEmail;
    }

    public String getCommitMessageFull() {
        return commitMessageFull;
    }

    public void setCommitMessageFull(String commitMessageFull) {
        this.commitMessageFull = commitMessageFull;
    }

    public String getCommitMessageShort() {
        return commitMessageShort;
    }

    public void setCommitMessageShort(String commitMessageShort) {
        this.commitMessageShort = commitMessageShort;
    }

    public String getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(String commitTime) {
        this.commitTime = commitTime;
    }

    public String getClosestTagName() {
        return closestTagName;
    }

    public void setClosestTagName(String closestTagName) {
        this.closestTagName = closestTagName;
    }

    public String getClosestTagCommitCount() {
        return closestTagCommitCount;
    }

    public void setClosestTagCommitCount(String closestTagCommitCount) {
        this.closestTagCommitCount = closestTagCommitCount;
    }

    public String getBuildUserName() {
        return buildUserName;
    }

    public void setBuildUserName(String buildUserName) {
        this.buildUserName = buildUserName;
    }

    public String getBuildUserEmail() {
        return buildUserEmail;
    }

    public void setBuildUserEmail(String buildUserEmail) {
        this.buildUserEmail = buildUserEmail;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public String getBuildHost() {
        return buildHost;
    }

    public void setBuildHost(String buildHost) {
        this.buildHost = buildHost;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }
}
