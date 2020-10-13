package com.firecode.app.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sessions")
public class SessionResource {

	@GetMapping("/{id}")
	public String openSession(Model model) {
		model.addAttribute("pageTitle", "Avaliações");
		model.addAttribute("headerTitle", "Avaliações");
		return "app/page/reader/assessment";		
	}

}
