package com.yesh.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;
	
	Integer getCountOfUsers() {
		return template.queryForObject("select count(*) from simple", Integer.class);
	}
	
	String createUser(String name, String address) {
		template.update("INSERT into simple (name, address) values (?,?)", name, address);
		return "User Created";
	}
	
	String update(Users users , Integer id){
		template.update("update simple set name = ?, address = ? where id = ?", users.getName(), users.getAddress(), id);
		return "User Updated";
	}
	
	String removeUser(Integer id) {
		template.update("delete from simple where id=?", id);
		return "User deleted";
	}
	
	String getUserById(Integer id) {
		String resset;
		SqlRowSet set = template.queryForRowSet("select name,address from simple where id = ?", id );
		set.next();
		resset = "Name=" + set.getString("name") + " Address = " + set.getString("address");
		return resset;
	}
}
