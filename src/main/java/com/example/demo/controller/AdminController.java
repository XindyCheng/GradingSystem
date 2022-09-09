package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.BusinessTitleDao;
import com.example.demo.entity.BusinessTitle;
import com.example.demo.entity.Display;
import com.example.demo.service.ClientProjectService;
import com.example.demo.service.DisplayService;
import com.example.demo.service.PMEntryService;

/**
 * 
 * @author cindy 后台管理页面的所有controller
 *
 */
@Controller
public class AdminController {
    @Autowired
    private PMEntryService entryService;
    @Autowired
    private ClientProjectService clientService;
    @Autowired
    private DisplayService displayService;
    @Autowired
    private BusinessTitleDao titleDao;

    // 方案经理上传的项目列表
    @GetMapping("/admin_project")
    public String toPmentry(Model model) {
        model.addAttribute("entry_list", entryService.getAll());
//        System.out.println(model.getAttribute("entry_list"));
        return "admin_project";
    }

    // 商机展示中的项目列表页面
    @GetMapping("/admin_display_list")
    public String toDisplayList(Model model) {
        model.addAttribute("display_list", displayService.getAll());
        return "admin_display_list";
    }

    // 添加商机页面
    @GetMapping("/admin_display_add")
    public String toDisplayAdd(Model model) {
        model.addAttribute("display", new Display());
        return "admin_display_add";
    }

    // 添加商机的方法
    @PostMapping("/addDisplay")
    public String addDisplay(@ModelAttribute Display display) {
        System.out.println(display);
        if (displayService.addDisplay(display) == 1) {
            return "thanks";
        }
        return null;
    }

    // 合作方上传的商机列表页面
    @GetMapping("/admin_client_project")
    public String toClientProject(Model model) {
        model.addAttribute("project_list", clientService.getAll());
        return "admin_client_project";
    }

    // 修改商机标题信息的页面
    @GetMapping("/admin_business_title")
    public String setTitle(Model model) {
        model.addAttribute("title", titleDao.selectById(1));
        return "admin_business_title";
    }

    // 修改商机标题信息的方法
    @PostMapping("/updateTitle")
    public String updateTitle(@ModelAttribute BusinessTitle title) {
        title.setId(1);
        System.out.println(title);
        if (titleDao.update(title) == 1) {
            return "admin_thanks";
        }
        return null;
    }

}
