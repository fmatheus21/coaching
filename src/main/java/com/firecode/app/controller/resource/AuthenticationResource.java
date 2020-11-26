package com.firecode.app.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authentication")
public class AuthenticationResource {

    @GetMapping
    public String login(Model model) {
        model.addAttribute("pageTitle", "Login");
        return "app/login";
    }

}
