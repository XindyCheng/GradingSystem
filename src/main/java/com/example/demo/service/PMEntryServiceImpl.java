package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
	
	public List<PMEntry> getAll(){
		return entrydao.selectAll();
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

}
