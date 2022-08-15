package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CMGradingDao;
import com.example.demo.entity.CMGrading;

@RestController
public class CMGradingController {
	@Autowired
	private CMGradingDao cmDao;
	

}
