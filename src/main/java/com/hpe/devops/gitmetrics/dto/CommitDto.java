package com.hpe.devops.gitmetrics.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CommitDto {
	@JsonInclude
	private String commitId;
	@JsonInclude
	private Date commitDate;
	@JsonInclude
	private String commitOwner;
	@JsonInclude
	private String commitOwnerEmail;
	
	public CommitDto (){
		
	}
	
	public CommitDto(String commitId, Date commitDate, String commitOwner, String commitOwnerEmail){
		this.commitId=commitId;
		this.commitDate=commitDate;
		this.commitOwner=commitOwner;
		this.commitOwnerEmail=commitOwnerEmail;
	}
	
	
	public String getCommitId() {
		return commitId;
	}
	public void setCommitId(String commitId) {
		this.commitId = commitId;
	}
	public Date getCommitDate() {
		return commitDate;
	}
	public void setCommitDate(Date commitDate) {
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

}
