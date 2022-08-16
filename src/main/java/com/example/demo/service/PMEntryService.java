package com.example.demo.service;

import java.util.HashMap;

import com.example.demo.entity.PMEntry;

public interface PMEntryService {
	public int insertEntry(PMEntry entry);
	public PMEntry getById(int id);
	public Integer addEntry(String contractnumber,String supplier,
			String client, Integer start, Double total, Integer state, Integer bg, String score,
			String pmname, String department, String cmname, String dmname, String comment);

}
