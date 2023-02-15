package com.douzone.jblog.vo;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
public class BlogVo {
	
	private String id;
	@NotEmpty
	private String title;
	@NotEmpty
	private String profile;
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", title=" + title + ", profile=" + profile + "]";
	}
}
