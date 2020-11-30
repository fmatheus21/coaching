package com.firecode.app.controller.resource;

import com.firecode.app.controller.rule.GlobalRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/team/coaching")
public class TeamCoachingResource {

    @Autowired
    private GlobalRule globalRule;

    @GetMapping
    public String openReader(Model model) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Team Coaching");
        model.addAttribute("headerTitle", "Team Coaching");
        model.addAttribute("buttonBack", false);
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/team/coaching/create");
        return "app/page/reader/team-coaching";
    }

    @GetMapping("/create")
    public String openCreate(Model model) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Team Coaching");
        model.addAttribute("headerTitle", "Team Coaching");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonAdd", false);
        model.addAttribute("buttonAddLink", "/team/coaching/create");
        return "app/page/create/team-coaching";
    }

    @GetMapping("/update/{id}")
    public String openUpdate(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Team Coaching");
        model.addAttribute("headerTitle", "Team Coaching");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/team/coaching/create");
        return "app/page/update/team-coaching";
    }

    @GetMapping("/view/{id}")
    public String openView(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Team Coaching");
        model.addAttribute("headerTitle", "Team Coaching");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/team/coaching/create");
        return "app/page/view/team-coaching";
    }

}
