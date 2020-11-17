package com.firecode.app.controller.resource;

import com.firecode.app.controller.dto.CoacheeDto;
import com.firecode.app.controller.rule.CoacheeRule;
import com.firecode.app.controller.rule.GlobalRule;
import com.firecode.app.controller.service.GenderService;
import com.firecode.app.controller.util.MessageValidationUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/coachees")
public class CoacheeResource {

    @Autowired
    private GlobalRule globalRule;

    @Autowired
    private GenderService genderService;

    @Autowired
    private CoacheeRule coacheeRule;

    @Autowired
    private MessageValidationUtil messageValidationUtil;

    @GetMapping
    public String openReader(Model model) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Coachees");
        model.addAttribute("headerTitle", "Coachees");
        model.addAttribute("formTitle", "Listar Coachees");
        model.addAttribute("buttonBack", false);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/coachees/create");
        model.addAttribute("listCoachees", coacheeRule.listAll());
        model.addAttribute("modelCoachee", new CoacheeDto());
        return "app/page/reader/coachee";
    }

    @GetMapping("/create")
    public String openCreate(Model model, HttpServletRequest request, HttpServletResponse response) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Coachees");
        model.addAttribute("headerTitle", "Coachees");
        model.addAttribute("formTitle", "Adicionar Coachee");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", false);
        model.addAttribute("buttonAddLink", "/coachees/create");
        model.addAttribute("listGender", genderService.findAll("name"));
        model.addAttribute("modelCoachee", coacheeRule.init(request, response));
        return "app/page/create/coachee";
    }

    @GetMapping("/update/{id}")
    public String openUpdate(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalRule.model(model);
        CoacheeDto coachee = coacheeRule.findById(id);
        if (coachee == null) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorNotFound());
            return "redirect:/coachees";
        }
        model.addAttribute("pageTitle", "Coachees");
        model.addAttribute("headerTitle", "Coachees");
        model.addAttribute("formTitle", "Editar Coachee");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/coachees/create");
        model.addAttribute("listGender", genderService.findAll("name"));
        model.addAttribute("modelCoachee", coachee);
        return "app/page/update/coachee";
    }

    @GetMapping("/view/{id}")
    public String openView(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalRule.model(model);
        CoacheeDto coachee = coacheeRule.findById(id);
        if (coachee == null) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorNotFound());
            return "redirect:/coachees";
        }
        model.addAttribute("pageTitle", "Coachees");
        model.addAttribute("headerTitle", "Coachees");
        model.addAttribute("formTitle", "Visualizar Coachee");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/coachees/create");
        model.addAttribute("modelCoachee", coachee);
        return "app/page/view/coachee";
    }

    @GetMapping("/assessments/view/{id}")
    public String viewCoacheAssessments(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Avaliações");
        model.addAttribute("headerTitle", "Avaliações");
        model.addAttribute("formTitle", "Visualizar Avaliações");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", false);
        model.addAttribute("buttonAddLink", "/coachees/create");
        return "app/page/view/assessments";
    }

    @GetMapping("/assessments/assessment/view/{id}")
    public String viewCoacheAssessmentsAssessment(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Avaliações");
        model.addAttribute("headerTitle", "Avaliações");
        model.addAttribute("formTitle", "Visualizar Avaliação");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", false);
        model.addAttribute("buttonAddLink", "/coachees/create");
        return "app/page/view/assessment";
    }

    @GetMapping("/{id}/assessments/reader")
    public String openCoacheAssessment(@PathVariable("id") int id, Model model) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Avaliações");
        model.addAttribute("headerTitle", "Avaliações");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonBackLink", "/coachees");
        return "app/page/reader/coachee-assessment";
    }

    @GetMapping("/{id}/session/reader")
    public String viewCoacheSession(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Sessões");
        model.addAttribute("headerTitle", "Sessões");
        model.addAttribute("formTitle", "Visualizar Sessões");
        model.addAttribute("buttonBack", false);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", false);
        model.addAttribute("buttonAddLink", "/coachees/create");
        return "app/page/view/coache-session";
    }

    @PostMapping("/create")
    public String create(@Valid CoacheeDto dto, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response) {
        return coacheeRule.create(dto, result, attributes, request, response);
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @Valid CoacheeDto dto, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response) {
        return coacheeRule.update(id, dto, result, attributes, request, response);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
        return coacheeRule.delete(id, attributes);
    }

}
