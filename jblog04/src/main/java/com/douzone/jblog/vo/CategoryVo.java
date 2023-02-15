package com.douzone.jblog.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
public class CategoryVo {

	private Long no;	
	
	private String id;
	@NotEmpty
	@NotNull
	private String name;
	private String description;
	private int count;
	
	public CategoryVo(String id,String name,String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
