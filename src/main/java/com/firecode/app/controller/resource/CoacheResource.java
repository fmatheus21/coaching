package com.firecode.app.controller.resource;

import com.firecode.app.controller.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/coaches")
public class CoacheResource {

    @Autowired
    private GlobalService globalService;
    
      @GetMapping
    public String openCoache(Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Coaches");
        model.addAttribute("headerTitle", "Coaches");
        model.addAttribute("buttonBack", false);
        return "app/page/reader/coache";
    }

    @GetMapping("/assessments/view/{id}")
    public String viewCoache(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Avaliações");
        model.addAttribute("headerTitle", "Avaliações");
        model.addAttribute("buttonBack", true);
        return "app/page/view/assessment";
    }

    @GetMapping("/assessments/reader/{id}")
    public String openCoacheAssessment(@PathVariable("id") int id, Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Avaliações");
        model.addAttribute("headerTitle", "Avaliações");
        model.addAttribute("buttonBack", true);
        return "app/page/reader/coache-assessment";
    }

  

}
