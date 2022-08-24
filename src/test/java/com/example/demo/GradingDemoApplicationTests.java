package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.PMEntryDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Department;
import com.example.demo.entity.PMEntry;
import com.example.demo.entity.User;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.JsonUtilService;

@SpringBootTest
class GradingDemoApplicationTests {
	@Autowired
	private DepartmentService deservice;
	
	@Test
	void getData() throws IOException {
		//deservice.deleteAll();//清除数据库中的单位列表
		deservice.importDepartments();
    }
}
