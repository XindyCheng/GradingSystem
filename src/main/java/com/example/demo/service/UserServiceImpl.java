package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public HashMap<Boolean, String> Login(String name, String psw) {
		HashMap<Boolean, String> result = new HashMap<Boolean, String>();
		User user = userDao.selectByName(name);
		if(user==null) {
			result.put(false, "用户不存在！");
			return result;
		}
		else if (psw.equals(user.getPassword())) {
			result.put(true, "登陆成功");
			return result;
		}
		else {
			result.put(false, "密码错误！");
			return result;
		}

	}



}
