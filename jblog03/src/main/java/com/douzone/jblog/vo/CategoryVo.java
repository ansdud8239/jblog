package com.douzone.jblog.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



public class CategoryVo {

	private Long no;

	private String id;
	@NotEmpty
	@NotNull
	private String name;
	private String description;
	private int count;

	public CategoryVo() {
	}

	public CategoryVo(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
