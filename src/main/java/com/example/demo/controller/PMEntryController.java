package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PMEntryDao;
import com.example.demo.entity.PMEntry;

@RestController
public class PMEntryController {
	@Autowired
	private PMEntryDao entrydao;
	
	@GetMapping("pmentry")
	public List<PMEntry> getAll() {
		return entrydao.selectAll();
	}
	
	@GetMapping("pmentry/{id}")
	public PMEntry getById(@PathVariable("id")Integer id) {
		PMEntry entry = entrydao.selectById(id);
		return entry;
	}
	
	@PostMapping("register")
	public String addEntry() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return e.getMessage();
		}
		return null;
	}

}
