package com.hpe.devops.gitmetrics.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CommitDto {
	@JsonInclude
	private String commitId;
	@JsonInclude
	private String commitDate;
	@JsonInclude
	private String commitOwner;
	@JsonInclude
	private String commitOwnerEmail;
	@JsonInclude
	private String commitMessage;
	
	public CommitDto (){
		
	}
	
	public CommitDto(String commitId, String commitDate, String commitOwner, String commitOwnerEmail, String commitMessage){
		this.commitId=commitId;
		this.commitDate=commitDate;
		this.commitOwner=commitOwner;
		this.commitOwnerEmail=commitOwnerEmail;
		this.commitMessage=commitMessage;
	}
	
	
	public String getCommitId() {
		return commitId;
	}
	public void setCommitId(String commitId) {
		this.commitId = commitId;
	}
	public String getCommitDate() {
		return commitDate;
	}
	public void setCommitDate(String commitDate) {
		this.commitDate = commitDate;
	}
	public String getCommitOwner() {
		return commitOwner;
	}
	public void setCommitOwner(String commitOwner) {
		this.commitOwner = commitOwner;
	}
	public String getCommitOwnerEmail() {
		return commitOwnerEmail;
	}
	public void setCommitOwnerEmail(String commitOwnerEmail) {
		this.commitOwnerEmail = commitOwnerEmail;
	}
	public String getCommitMessage() {return commitMessage;}
	public void setCommitMessage(String commitMessage) {this.commitMessage = commitMessage; }

}
