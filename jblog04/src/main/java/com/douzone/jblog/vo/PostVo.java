package com.douzone.jblog.vo;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostVo {
	
	@NotEmpty
	private Long no;
	@NotEmpty
	private String title;
	@NotEmpty
	private String contents;
	@NotEmpty
	private String regDate;	
	@NotEmpty
	private Long categoryNo;
	@Override
	public String toString() {
		return "PostVo [no=" + no + ", title=" + title + ", contents=" + contents + ", regDate=" + regDate
				+ ", categoryNo=" + categoryNo + "]";
	}
	
	
}
