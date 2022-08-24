package com.example.demo.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DMGradingDao;
import com.example.demo.entity.DMGrading;

@Service
public class DMGradingServiceImpl implements DMGradingService{
	@Autowired
	@Resource
	private DMGradingDao gradingdao;
	
	public int add(DMGrading grading) {
		Integer insert_code = 0;
		double total=grading.getCompl_tl() + grading.getConstructability() +
				grading.getCustomer_satisfaction() + grading.getDeliver_quality() +
				grading.getRes_tl() + grading.getTechnique();
		grading.setTotal(total);
		Date date = new Date();
		grading.setTime(date);
		final Log log=LogFactory.getLog(DMGradingServiceImpl.class);
		log.info(grading);
		insert_code = gradingdao.insert(grading);
		return insert_code;
		
	}

}
