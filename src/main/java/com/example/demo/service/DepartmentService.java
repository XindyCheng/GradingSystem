package com.example.demo.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.DepartmentDao;
import com.example.demo.entity.Department;

@Service
public class DepartmentService {
	@Autowired
	@Resource
	private DepartmentDao departmentDao;
	
	@Autowired 
	private JsonUtilService jsonservice;
	
	public int deleteAll() {
		return departmentDao.deleteAll();
	}
	
	public Department getById(int id) {
		return departmentDao.selectById(id);
	}
	
	public Department getByPid(int pid) {
		return departmentDao.selectByPid(pid);
	}
	
	public String toString(int unit1,int unit2, int unit3, int unit4) {
		String departmentString = departmentDao.selectById(unit1).getName();
		if (unit2 != -1) {
			departmentString = departmentString + "-" + departmentDao.selectById(unit2).getName();
			if (unit3 != -1) {
				departmentString = departmentString + "-" + departmentDao.selectById(unit3).getName();
				if (unit4 != -1) {
					departmentString = departmentString + "-" + departmentDao.selectById(unit4).getName();
					
				}
			}
		}
		
		return departmentString;
	}
	
	public void importDepartments() throws IOException{
		String value = jsonservice.getData();
        JSONArray jsonArray = JSONObject.parseArray(value);

        //遍历每一个json对象，将内容存放到Product对象中
        for (Object obj : jsonArray) {
            JSONObject jobj = (JSONObject) obj;
            Integer id = Integer.parseInt(jobj.getString("id"));
            Integer layer = Integer.parseInt(jobj.getString("layer"));
            Integer pid = Integer.parseInt(jobj.getString("p_id"));
            String name = jobj.getString("name");
 
            Department department = new Department();
            department.setId(id);
            department.setLayer(layer);
            department.setName(name);
            department.setPid(pid);
 
            //数据插入
            departmentDao.addDepartment(department);
        }
	}

}
