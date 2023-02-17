package com.douzone.jblog.vo;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo {
	
	@NotEmpty
	private String id;
	@NotEmpty
	@Length(min=2,max=8)
	private String name;
	@NotEmpty
	private String password;

	private String joinDate;
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + ", password=" + password + ", joinDate=" + joinDate + "]";
	}	
	
}
