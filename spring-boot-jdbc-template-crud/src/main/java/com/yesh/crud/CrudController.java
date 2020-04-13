package com.yesh.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {

	@Autowired
	Crudservice service;
	
	@RequestMapping("/count")
	Integer getCountOfUsers() {
		return service.getCountOfUsers();
	}
	
	@RequestMapping("/users/create/{name}/{address}")
	String createUser(@PathVariable String name,@PathVariable String address) {
		return service.createUser(name, address);
	}
	
	@RequestMapping(method= RequestMethod.PUT, value= "/users/update/{id}")
	String update(@RequestBody Users users, @PathVariable Integer id) {
		return service.update(users, id);
	}
	
	@RequestMapping("/users/remove/{id}")
	String removeUser(@PathVariable Integer id) {
		return service.removeUser(id);
	}
	
	@RequestMapping("/users/getbyid/{id}")
	String getUserById(@PathVariable Integer id) {
		return service.getUserById(id);
	}	
}
