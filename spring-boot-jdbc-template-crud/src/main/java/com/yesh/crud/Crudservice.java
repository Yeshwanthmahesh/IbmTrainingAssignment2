package com.yesh.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class Crudservice {

	@Autowired
	UserDao dao;
	
	Integer getCountOfUsers() {
		return dao.getCountOfUsers();
	}
	
	String createUser(String name, String address) {
		return dao.createUser(name, address);
	}
	
	String update(Users users, Integer id){
		return dao.update(users, id);
	}
	
	String removeUser(Integer id) {
		return dao.removeUser(id);
	}
	
	String getUserById(Integer id) {
		return dao.getUserById(id);
	}
}
