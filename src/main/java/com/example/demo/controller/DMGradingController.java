package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.DMGrading;
import com.example.demo.service.DMGradingService;
import com.example.demo.service.DepartmentService;

@Controller
public class DMGradingController {
	@Autowired
	private DMGradingService gradingService;
	
	@Autowired
	private DepartmentService deService;
	
	@GetMapping("/dmgrading")
	public String toCmgrading(Model model) {
		model.addAttribute("grading", new DMGrading());
		return "/dmgrading";
	}
	
	@PostMapping("/addDMGrading")
	public String addGrading(@ModelAttribute DMGrading grading, 
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
