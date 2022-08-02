package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PMEntryDao;
import com.example.demo.entity.PMEntry;

@Service
public class PMEntryServiceImpl implements PMEntrySevice{

	@Autowired
	@Resource
	private PMEntryDao entry;
	public int insertEntry(PMEntry entry) {
		
		return 0;
		
	}
	

}
