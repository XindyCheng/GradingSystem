package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
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
	 // 检查用户是否已登录，防止网页重复提交表单
    @GetMapping("/admin_login")
    public String checklogin(HttpSession session, Model model){
        if(session.getAttribute("loginUser")!=null){
            return "admin_index";
        }else{
            return "admin_login";
        }
    }
    // 提交表单后后进入index页面的函数
    // 使用重定向的方法，防止网页重复提交表单
    @PostMapping(value = "/AdminLogin")
    public String Login(@RequestParam("username")String username,
            @RequestParam("password") String password, HttpSession session, Model model){
        if(StringUtils.isEmpty(username)) {
            model.addAttribute("msg","请输入用户名！");
            return "admin_login";
        }
        else if (StringUtils.isEmpty(password)) {
            model.addAttribute("msg","请输入密码！");
            return "admin_login";
        }
        else {
            HashMap<Boolean, String> loginResult = new HashMap<Boolean, String>();
            loginResult = userService.Login(username, password);
            if (loginResult.containsKey(true)) {
                model.addAttribute("msg",loginResult.get(true));
                User user=new User();
                user.setName(username);
                user.setPassword(password);
                session.setAttribute("loginUser",user);
                return "admin_index";
            }else {
                model.addAttribute("msg",loginResult.get(false));
                return "admin_login";
            }
        }
    }

    // 重定向或刷新网页 index
    @GetMapping("/admin_index")
    public String MainPage(HttpSession session, Model model){
        if(session.getAttribute("loginUser")!=null){
            return "admin_index";
        }else{
            model.addAttribute("msg","会话过期，请重新登录");
            return "admin_login";
        }
    }
	
}
