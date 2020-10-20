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
    public String openReader(Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Coaches");
        model.addAttribute("headerTitle", "Coaches");
        model.addAttribute("formTitle", "Listar Coaches");
        model.addAttribute("buttonBack", false);
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/coaches/create");
        return "app/page/reader/coache";
    }

    @GetMapping("/create")
    public String openCreate(Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Coaches");
        model.addAttribute("headerTitle", "Coaches");
        model.addAttribute("formTitle", "Adicionar Coache");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonAdd", false);
        model.addAttribute("buttonAddLink", "/coaches/create");
        return "app/page/create/coache";
    }

    @GetMapping("/update/{id}")
    public String openUpdate(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Coaches");
        model.addAttribute("headerTitle", "Coaches");
        model.addAttribute("formTitle", "Editar Coache");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/coaches/create");
        return "app/page/update/coache";
    }

    @GetMapping("/view/{id}")
    public String openView(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Coaches");
        model.addAttribute("headerTitle", "Coaches");
        model.addAttribute("formTitle", "Visualizar Coache");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/coaches/create");
        return "app/page/view/coache";
    }

    @GetMapping("/assessments/view/{id}")
    public String viewCoacheAssessments(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Avaliações");
        model.addAttribute("headerTitle", "Avaliações");
        model.addAttribute("formTitle", "Visualizar Avaliações");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonAdd", false);
        model.addAttribute("buttonAddLink", "/coaches/create");
        return "app/page/view/assessments";
    }

    @GetMapping("/assessments/assessment/view/{id}")
    public String viewCoacheAssessmentsAssessment(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
         globalService.model(model);
        model.addAttribute("pageTitle", "Avaliações");
        model.addAttribute("headerTitle", "Avaliações");
        model.addAttribute("formTitle", "Visualizar Avaliação");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonAdd", false);
        model.addAttribute("buttonAddLink", "/coaches/create");
        return "app/page/view/assessment";
    }

    @GetMapping("/{id}/assessments/reader")
    public String openCoacheAssessment(@PathVariable("id") int id, Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Avaliações");
        model.addAttribute("headerTitle", "Avaliações");
        model.addAttribute("buttonBack", true);
        return "app/page/reader/coache-assessment";
    }
    
    
     @GetMapping("/{id}/session/reader")
    public String viewCoacheSession(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalService.model(model);
        model.addAttribute("pageTitle", "Sessões");
        model.addAttribute("headerTitle", "Sessões");
        model.addAttribute("formTitle", "Visualizar Sessões");
        model.addAttribute("buttonBack", false);
        model.addAttribute("buttonAdd", false);
        model.addAttribute("buttonAddLink", "/coaches/create");
        return "app/page/view/coache-session";
    }

}
