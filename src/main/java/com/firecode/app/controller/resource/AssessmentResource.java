package com.firecode.app.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/assessments")
public class AssessmentResource {

   
    
    @GetMapping("/view/{id}")
    public String viewCoache(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        model.addAttribute("pageTitle", "Avaliações");
        model.addAttribute("headerTitle", "Avaliações");
        model.addAttribute("buttonBack", true);
        return "app/page/view/assessment";
    }

}
