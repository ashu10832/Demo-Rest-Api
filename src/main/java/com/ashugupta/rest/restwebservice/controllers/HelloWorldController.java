package com.ashugupta.rest.restwebservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashugupta.rest.restwebservice.models.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	// GET /helloworld
	// helloword
	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	// helloworld bean
	@GetMapping(path="/helloworldbean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("HelloWorldBean");
	}
	
	// helloworld bean
	@GetMapping(path="/helloworldbean/{name}")
	public HelloWorldBean helloWorldName(@PathVariable String name) {
		return new HelloWorldBean("HelloWorldBean " + name);
	}
	
	

}
