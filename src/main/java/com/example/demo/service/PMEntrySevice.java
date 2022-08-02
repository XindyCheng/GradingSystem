package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PMEntry;


@Service
public interface PMEntrySevice {
	public int insertEntry(PMEntry entry);
}
