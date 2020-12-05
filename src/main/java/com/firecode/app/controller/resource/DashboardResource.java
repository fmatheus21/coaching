package com.firecode.app.controller.resource;

import com.firecode.app.controller.rule.GlobalRule;
import com.firecode.app.controller.security.AppUserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class DashboardResource {

    @Autowired
    private GlobalRule globalRule;

    @GetMapping
    public String openDashboard(Model model, @AuthenticationPrincipal AppUserSecurity appUserSecurity) {
        globalRule.model(model, appUserSecurity);
        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("headerTitle", "Dashboard");
        return "app/page/dashboard";
    }

}
