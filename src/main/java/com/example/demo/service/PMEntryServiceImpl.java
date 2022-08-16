package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PMEntryDao;
import com.example.demo.entity.PMEntry;

@Service
public class PMEntryServiceImpl implements PMEntryService{

	@Autowired
	@Resource
	private PMEntryDao entrydao;
	
	public PMEntry getById(int id) {
		return entrydao.selectById(id);
	}
	
	public int insertEntry(PMEntry entry) {
		Date date = new Date();
		entry.setTime(date);
		Integer insert_code = 0;
		final Log log=LogFactory.getLog(PMEntryServiceImpl.class);
		log.info(entry);
		insert_code = entrydao.insert(entry);
//		try {
//			insert_code = entrydao.insert(entry);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		return insert_code;
		
	}
	public Integer addEntry(String contractnumber,String supplier,
			String client, Integer start, Double total, Integer state, Integer bg, String score,
			String pmname, String department, String cmname, String dmname, String comment){
		PMEntry entry = new PMEntry();
		Date date = new Date();
		entry.setTime(date);
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		formatter.format(date);
		entry.setBg(bg);
		entry.setClient(client);
		entry.setCmname(cmname);
		entry.setComment(comment);
		entry.setContractnumber(contractnumber);
		entry.setDepartment(department);
		entry.setDmname(dmname);
		entry.setPmname(pmname);
		entry.setScore(score);
		entry.setStart(start);
		entry.setState(state);
		entry.setSupplier(supplier);
		entry.setTotal(total);
		Integer insert_code = 0;
		try {
			insert_code = entrydao.insert(entry);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return insert_code;
	}
	

}
