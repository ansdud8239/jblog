package com.douzone.jblog.vo;

import javax.validation.constraints.NotEmpty;

public class BlogVo {
	
	private String id;
	@NotEmpty
	private String title;
	@NotEmpty
	private String profile;
	public BlogVo() {
	}
	
	public BlogVo(String id,String title,String profile) {
		this.id = id;
		this.title = title;
		this.profile = profile;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", title=" + title + ", profile=" + profile + "]";
	}
}
