package com.ashugupta.rest.restwebservice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ashugupta.rest.restwebservice.models.User;

@Component
public class UserDao {
	
	private static List<User> users = new ArrayList();
	private static Integer userCount = 3;
	
	static {
		users.add(new User(1, "ashu", new Date()));
		users.add(new User(2, "vishu", new Date()));
		users.add(new User(3, "mummy", new Date()));

	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		
		return user;
	}
	
	public User fineOne(Integer id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(Integer id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	

}
