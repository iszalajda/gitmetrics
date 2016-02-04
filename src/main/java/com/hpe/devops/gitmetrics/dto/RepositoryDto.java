 package com.hpe.devops.gitmetrics.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class RepositoryDto {
	
	@JsonInclude
	private String name;
	
	
	@JsonInclude
	private String url;
	
	public RepositoryDto(){
		
	}
	
	public RepositoryDto(String name, String url ){
		this.name=name;
		this.url=url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
