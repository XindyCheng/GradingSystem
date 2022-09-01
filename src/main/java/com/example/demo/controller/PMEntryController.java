package com.example.demo.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.log.LogDelegateFactory;
import org.springframework.core.log.LogMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.cofig.WebMvcConfig;
import com.example.demo.dao.PMEntryDao;
import com.example.demo.entity.PMEntry;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.PMEntryService;
import com.example.demo.service.RelationshipService;

@Controller
public class PMEntryController {
	@Autowired
	private PMEntryService entryService;
	@Autowired
	private DepartmentService deService;
	
	@GetMapping("pmentry={id}")
	public String getById(@PathVariable("id")Integer id, Model model) {
		PMEntry entry = entryService.getById(id);
		model.addAttribute("entry", entry);
		final Log log=LogFactory.getLog(PMEntryController.class);
		log.info("pmentryController.getById");
		return "pmentry_refer";
	}
	
	@ResponseBody
	@PostMapping("/detail")
	public PMEntry detail(Model model,Integer id){
		System.out.println("执行查询操作：id="+id);
		model.addAttribute("entryDetail", entryService.getById(id));
		System.out.println(model.getAttribute("entryDetail"));
		return entryService.getById(id);
	}
	
//    /**
//     * 模拟异步请求响应
//     */
//    @RequestMapping(value = "/testDetail")
//    public @ResponseBody PMEntry testDetail(@RequestBody Integer id){
//        System.out.println("testAjax方法执行了");
//        PMEntry entry = entryService.getById(id);
//        System.out.println(entry);
//        return entry;
//    }

	
	@GetMapping("/pmentry")
	public String toPmentry(Model model) {
		model.addAttribute("entry", new PMEntry());
		return "pmentry";
	}
	
	@GetMapping("/grading_list")
	public String toList(Model model) {
		model.addAttribute("entry_list", entryService.getAll());
		model.addAttribute("entryDetail", new PMEntry());
		return "grading_list";
	}
	
	
	@PostMapping("/addEntry")
	public String addEntry(@ModelAttribute PMEntry entry, 
			@RequestParam(name="unit1", defaultValue="-1")Integer unit1,
			@RequestParam(name="unit2", defaultValue="-1")Integer unit2,
			@RequestParam(name="unit3", defaultValue="-1")Integer unit3,
			@RequestParam(name="unit4", defaultValue="-1")Integer unit4) {
		String departmentString = deService.toString(unit1, unit2, unit3, unit4);
//		final Log log=LogFactory.getLog(PMEntryController.class);
//		log.info(unit1);
		entry.setDepartment(departmentString);
		if(entryService.insertEntry(entry)==1) {
			return "thanks";
		}
		return null;
	}

}
