package com.firecode.app.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class DashboardResource {

    @GetMapping
    public String openDashboard(Model model) {
        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("headerTitle", "Dashboard");
        return "app/page/dashboard";
    }

}
