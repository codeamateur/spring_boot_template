package com.template.model.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PersonDto {

	@NotEmpty(message="{people.name.notEmpty}")
	private String name;
	@NotNull(message="{people.age.notNull}")
	private Integer age;
	
	public PersonDto() {
		super();
	}
	public PersonDto(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
