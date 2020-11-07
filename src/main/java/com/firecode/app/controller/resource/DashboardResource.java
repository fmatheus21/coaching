package com.firecode.app.controller.resource;

import com.firecode.app.controller.service.CoacheeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class DashboardResource {
    
    @Autowired private CoacheeService coachService;

    @GetMapping
    public String openDashboard(Model model) {
        coachService.search(); 
        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("headerTitle", "Dashboard");
        return "app/page/dashboard";
    }

}
