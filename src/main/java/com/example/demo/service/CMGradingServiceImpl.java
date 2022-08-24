package com.example.demo.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CMGradingDao;
import com.example.demo.entity.CMGrading;

@Service
public class CMGradingServiceImpl implements CMGradingService{
	
	@Autowired
	@Resource
	private CMGradingDao gradingdao;
	
	public int add(CMGrading grading) {
		Integer insert_code = 0;
		double total=grading.getCredibility() + grading.getCustomerrelat() + 
				grading.getPersonnelquality() + grading.getProjectsupport();
		grading.setTotal(total);
		Date date = new Date();
		grading.setTime(date);
		final Log log=LogFactory.getLog(CMGradingServiceImpl.class);
		log.info(grading);
		insert_code = gradingdao.insert(grading);
		return insert_code;
	}
	
}
