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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.CMGrading;
import com.example.demo.service.CMGradingService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.RelationshipService;

@Controller
public class CMGradingController {
    @Autowired
    private CMGradingService gradingService;
    @Autowired
    private DepartmentService deService;
    @Autowired
    private RelationshipService relatService;

    private Integer current_project = -1;// 记录当前选择了哪个项目

    @GetMapping("/cmgrading")
    public String toCmgrading(Model model) {
        model.addAttribute("grading", new CMGrading());
        return "/cmgrading";
    }

    @ResponseBody
    @PostMapping("/changeProjectCM")
    public int changeProject(Model model, Integer pm_id) {
        current_project = pm_id;
        return current_project;
    }

    @PostMapping("/CMEntryDatil")
    public String CMEntryDatil(Model model, Integer id) {

        return "/cmgrading";
    }

    @PostMapping("/addCMGrading")
    public String addGrading(@ModelAttribute CMGrading grading,
            @RequestParam(name = "unit1", defaultValue = "-1") Integer unit1,
            @RequestParam(name = "unit2", defaultValue = "-1") Integer unit2,
            @RequestParam(name = "unit3", defaultValue = "-1") Integer unit3,
            @RequestParam(name = "unit4", defaultValue = "-1") Integer unit4) {
        String departmentString = deService.toString(unit1, unit2, unit3, unit4);
        final Log log = LogFactory.getLog(CMGradingController.class);
        log.info(grading);
        grading.setUnit(departmentString);
        // 添加评分表
        Integer cm_id = gradingService.add(grading);
        double cm_total = gradingService.getTotalById(cm_id);
        if (cm_id >= 1) {
            // 更新方案经理录入表
            System.out.println("更新项目：pm_id:" + current_project + ", cm_id:" + cm_id);
            if (relatService.renewCM(current_project, cm_id, cm_total) == 1) {
                return "thanks";
            }
        }

        return null;
    }

}
