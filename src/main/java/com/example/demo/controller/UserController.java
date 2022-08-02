package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	@Resource
	private UserService userService;
	
	@GetMapping("user/{id}")
	public User getById(@PathVariable("id")Integer id) {
		User user = userService.getById(id);
		return user;
		
	}
	
	@GetMapping("user")
	public List<User> getAll() {
		return userService.getAll();
		
	}
	
//	@GetMapping("user/{name}")
//	public Integer getByName(@PathVariable("name")String name) {
//		User user = userService.getByName(name);
//		return user.id;
//		
//	}
	
}
