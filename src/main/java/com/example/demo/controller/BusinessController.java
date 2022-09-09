package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.BusinessTitleDao;
import com.example.demo.entity.ClientProject;
import com.example.demo.service.ClientProjectService;

@Controller
public class BusinessController {
    @Autowired
    private ClientProjectService clientService;

    // 用于设置页面的几个标题信息,逻辑简单，没有service层，直接操作DAO层
    @Autowired
    private BusinessTitleDao titleDao;

    @GetMapping("/business_opportunity")
    public String toBusiness(Model model) {
        model.addAttribute("title_info", titleDao.selectById(1));
        model.addAttribute("project", new ClientProject());
        return "business_opportunity";
    }

    @PostMapping("/addClientProject")
    public String addClientProject(@ModelAttribute ClientProject project) {
        if (clientService.add(project) == 1) {
            return "thanks";
        }
        return null;
    }

}
