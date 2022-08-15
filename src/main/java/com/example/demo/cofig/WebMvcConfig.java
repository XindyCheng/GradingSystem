package com.example.demo.cofig;

import java.io.Console;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.controller.PMEntryController;
import com.example.demo.entity.PMEntry;

/**
 * 此类用于映射html页面，实现html之间的跳转
 */
@Configuration
@Controller
public class WebMvcConfig implements WebMvcConfigurer{

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("cmgrading").setViewName("/cmgrading/");
//	}
	@GetMapping("/cmgrading")
	public String cm_index() {	
		final Log log=LogFactory.getLog(WebMvcConfig.class);
		log.info("cm_webMvcConfig");
		return "cmgrading";
	}
	
	@GetMapping("/dmgrading")
	public String dm_index() {	
		final Log log=LogFactory.getLog(WebMvcConfig.class);
		log.info("dm_webMvcConfig");
		return "dmgrading";
	}
	
	@GetMapping("/pmentry_refer")
	public String pmRefer_index() {	
		final Log log=LogFactory.getLog(WebMvcConfig.class);
		log.info("pmRefer_webMvcConfig");
		return "pmentry_refer";
	}
	
	@GetMapping("/pmentry")
	public String pm_index() {	
		final Log log=LogFactory.getLog(WebMvcConfig.class);
		log.info("pm_webMvcConfig");
		return "pmentry";
	}




	




	

}