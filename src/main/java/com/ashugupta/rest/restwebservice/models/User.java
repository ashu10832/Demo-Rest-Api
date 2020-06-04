package com.ashugupta.rest.restwebservice.models;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details of the User")
public class User extends RepresentationModel<User> {
	
	Integer id;
	
	@ApiModelProperty(notes = "Name should have atleast 2 characters")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	String name;
	
	@ApiModelProperty(notes = "Birthdate should be in the past")
	@Past(message = "Birthdate should be in past")
	Date birthdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	
	@JsonCreator
	public void setBirthdate(@JsonProperty("birthdate") Date birthdate) {
		this.birthdate = birthdate;
	}
	
	@JsonCreator
	public User(@JsonProperty("id") Integer id, String name, java.util.Date date) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}

}
