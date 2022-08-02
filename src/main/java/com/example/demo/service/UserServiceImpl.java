package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	@Resource
	private UserDao userDao;

	public List<User> getAll(){
		return userDao.selectAll();
	}
	
	public User getById(int id) {
		return userDao.selectById(id);
	}
	
	public User getByName(String name) {
		return userDao.selectByName(name);
	}



}
