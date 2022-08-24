package com.example.demo.cofig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 此类用于映射html页面，实现html之间的跳转
 */
@Configuration
@Controller
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/cmgrading").setViewName("cmgrading");
		registry.addViewController("/dmgrading").setViewName("dmgrading");
		registry.addViewController("/pmentry").setViewName("pmentry");
		registry.addViewController("/pmentry_refer").setViewName("pmentry_refer");
		registry.addViewController("/admin_login").setViewName("admin_login");
		registry.addViewController("/admin_index").setViewName("admin_index");
		registry.addViewController("/admin_project").setViewName("admin_project");
		registry.addViewController("/thanks").setViewName("thanks");
//		registry.addViewController("/grading_list").setViewName("grading_list");
	}
//	@GetMapping("/cmgrading")
//	public String cm_index() {	
//		final Log log=LogFactory.getLog(WebMvcConfig.class);
//		log.info("cm_webMvcConfig");
//		return "cmgrading";
//	}


}