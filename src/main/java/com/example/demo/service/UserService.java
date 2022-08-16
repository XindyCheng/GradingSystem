package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.entity.User;

@Service
public interface UserService {

	public List<User> getAll();
	public User getById(int id);
	public User getByName(String name);
	public HashMap<Boolean, String> Login(String name, String psw);
}
