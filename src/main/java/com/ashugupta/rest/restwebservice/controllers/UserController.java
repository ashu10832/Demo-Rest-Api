package com.ashugupta.rest.restwebservice.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.ashugupta.rest.restwebservice.dao.UserDao;
import com.ashugupta.rest.restwebservice.exceptions.UserNotFoundException;
import com.ashugupta.rest.restwebservice.models.User;

@RestController
public class UserController {
	
	@Autowired
	UserDao userdao;
	
	// GET /users retrieve all
	@GetMapping(path = "/users")
	public List<User> retrieveAll(){
		return userdao.findAll();
	}
	
	// GET /users/{id} retrieve user(id)
	@GetMapping(path = "/users/{id}")
	public RepresentationModel<User> retrieveOne(@PathVariable Integer id) throws UserNotFoundException{
		User user =  userdao.fineOne(id);
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		
		user.add(linkTo(methodOn(this.getClass()).retrieveAll()).withRel("all-users"));
		
		return user;

	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User newUser = userdao.save(user);
		UriComponents location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(newUser.getId());
		
		return ResponseEntity.created(location.toUri()).build();
		
	}
	
	@DeleteMapping(path="/users/{id}")
	public User delete(@PathVariable Integer id) throws UserNotFoundException{
		User user =  userdao.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}
	
	

}
