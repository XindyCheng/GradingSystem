package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CMGradingDao;
import com.example.demo.entity.CMGrading;
import com.example.demo.service.CMGradingService;
import com.example.demo.service.DepartmentService;

@Controller
public class CMGradingController {
	@Autowired
	private CMGradingService gradingService;
	@Autowired
	private DepartmentService deService;
	
	@GetMapping("/cmgrading")
	public String toCmgrading(Model model) {
		model.addAttribute("grading", new CMGrading());
		return "/cmgrading";
	}
	
	@PostMapping("/addCMGrading")
	public String addGrading(@ModelAttribute CMGrading grading, 
			@RequestParam(name="unit1", defaultValue="-1")Integer unit1,
			@RequestParam(name="unit2", defaultValue="-1")Integer unit2,
			@RequestParam(name="unit3", defaultValue="-1")Integer unit3,
			@RequestParam(name="unit4", defaultValue="-1")Integer unit4) {
		String departmentString = deService.toString(unit1, unit2, unit3, unit4);
		final Log log = LogFactory.getLog(CMGradingController.class);
		log.info(grading);
		grading.setUnit(departmentString);
		if (gradingService.add(grading)==1) {
			return "thanks";
		}
		return null;
	}

}
