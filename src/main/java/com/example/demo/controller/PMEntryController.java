package com.example.demo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.cofig.WebMvcConfig;
import com.example.demo.dao.PMEntryDao;
import com.example.demo.entity.PMEntry;
import com.example.demo.service.PMEntryService;

@Controller
public class PMEntryController {
	@Autowired
	private PMEntryService entryService;
	
	@GetMapping("pmentry={id}")
	public String getById(@PathVariable("id")Integer id, Model model) {
		PMEntry entry = entryService.getById(id);
		model.addAttribute("entry", entry);
		final Log log=LogFactory.getLog(PMEntryController.class);
		log.info("pmentryController.getById");
		return "pmentry_refer";
	}
	
	@GetMapping("/pmentry")
	public String toPmentry(Model model) {
		model.addAttribute("entry", new PMEntry());
		return "pmentry";
	}
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes) {
//        boolean b = userService.deleteUserById(id);
//        if (b) {
//            attributes.addFlashAttribute("message", "删除用户成功");
//            return "redirect:/";
//        } else {
//            attributes.addFlashAttribute("message", "删除用户失败");
//            return "redirect:/";
//        }
//    }
	
	@PostMapping("/addEntry")
	public String addEntry(@ModelAttribute PMEntry entry) {
		if(entryService.insertEntry(entry)==1) {
			return "thanks";
		}
		return null;
	}

}
