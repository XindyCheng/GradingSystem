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

import com.example.demo.entity.DMGrading;
import com.example.demo.service.DMGradingService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.RelationshipService;

@Controller
public class DMGradingController {
    @Autowired
    private DMGradingService gradingService;
    @Autowired
    private DepartmentService deService;
    @Autowired
    private RelationshipService relatService;

    private Integer current_project = -1;// 记录当前选择了哪个项目

    @GetMapping("/dmgrading")
    public String toDmgrading(Model model) {
        model.addAttribute("grading", new DMGrading());
        return "/dmgrading";
    }

    @ResponseBody
    @PostMapping("/changeProjectDM")
    public int changeProject(Model model, Integer pm_id) {
        current_project = pm_id;
        return current_project;
    }

    @PostMapping("/addDMGrading")
    public String addGrading(@ModelAttribute DMGrading grading,
            @RequestParam(name = "unit1", defaultValue = "-1") Integer unit1,
            @RequestParam(name = "unit2", defaultValue = "-1") Integer unit2,
            @RequestParam(name = "unit3", defaultValue = "-1") Integer unit3,
            @RequestParam(name = "unit4", defaultValue = "-1") Integer unit4) {
        String departmentString = deService.toString(unit1, unit2, unit3, unit4);
        final Log log = LogFactory.getLog(DMGradingController.class);
        log.info(grading);
        grading.setUnit(departmentString);
        // 添加评分表
        Integer dm_id = gradingService.add(grading);
        double dm_total = gradingService.getTotalById(dm_id);
        if (dm_id >= 1) {
            // 更新方案经理录入表
            System.out.println("更新项目：pm_id:" + current_project + ", dm_id:" + dm_id);
            if (relatService.renewDM(current_project, dm_id, dm_total) == 1) {
                return "thanks";
            }
        }

        return null;
    }

}
