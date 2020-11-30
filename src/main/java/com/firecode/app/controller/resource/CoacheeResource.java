package com.firecode.app.controller.resource;

import com.firecode.app.controller.dto.CoacheeDto;
import com.firecode.app.controller.rule.CoacheeRule;
import com.firecode.app.controller.rule.FilterRule;
import com.firecode.app.controller.rule.GlobalRule;
import com.firecode.app.controller.rule.TesteRule;
import com.firecode.app.model.service.GenderService;
import com.firecode.app.controller.util.MessageValidationUtil;
import com.firecode.app.controller.util.UploadMultipartFileUtil;
import com.firecode.app.model.repository.filter.RepositoryFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    private FilterRule filterRule;

    @Autowired
    private TesteRule testeRule;

    @GetMapping
    public String openReader(Model model, RepositoryFilter filter, Pageable pageable) {
        globalRule.model(model);
        model.addAttribute("pageTitle", "Coachees");
        model.addAttribute("headerTitle", "Coachees");
        model.addAttribute("formTitle", "Listar Coachees");
        model.addAttribute("buttonBack", false);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/coachees/create");
        model.addAttribute("modelPage", coacheeRule.findAllPaginator(filter, pageable));
        model.addAttribute("modelCoachee", new CoacheeDto());
        model.addAttribute("modelFilter", new RepositoryFilter());
        model.addAttribute("modelUrl", "/coachees?");

        //testeRule.createCoachee();
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
        model.addAttribute("upload", new UploadMultipartFileUtil());
        return "app/page/create/coachee";
    }

    @GetMapping("/update/{id}")
    public String openUpdate(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {

        String redirectSuccess = "app/page/update/coachee";
        String redirectFailure = "redirect:/coachees";

        CoacheeDto coachee = coacheeRule.findById(id);

        globalRule.model(model);
        model.addAttribute("pageTitle", "Coachees");
        model.addAttribute("headerTitle", "Coachees");
        model.addAttribute("formTitle", "Editar Coachee");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/coachees/create");
        model.addAttribute("listGender", genderService.findAll("name"));
        model.addAttribute("modelCoachee", coachee);
        model.addAttribute("upload", new UploadMultipartFileUtil());
        return coacheeRule.validationRedirect(redirectSuccess, redirectFailure, coachee, attributes);

    }

    @GetMapping("/view/{id}")
    public String openView(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {

        String redirectSuccess = "app/page/view/coachee";
        String redirectFailure = "redirect:/coachees";

        CoacheeDto coachee = coacheeRule.findById(id);

        globalRule.model(model);
        model.addAttribute("pageTitle", "Coachees");
        model.addAttribute("headerTitle", "Coachees");
        model.addAttribute("formTitle", "Visualizar Coachee");
        model.addAttribute("buttonBack", true);
        model.addAttribute("buttonBackLink", "/coachees");
        model.addAttribute("buttonAdd", true);
        model.addAttribute("buttonAddLink", "/coachees/create");
        model.addAttribute("modelCoachee", coachee);
        return coacheeRule.validationRedirect(redirectSuccess, redirectFailure, coachee, attributes);

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
    public String create(@Valid CoacheeDto dto, BindingResult result, RedirectAttributes attributes, @ModelAttribute("upload") UploadMultipartFileUtil upload, HttpServletRequest request, HttpServletResponse response) {
        return coacheeRule.create(dto, result, attributes, upload, request, response);
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @Valid CoacheeDto dto, BindingResult result, RedirectAttributes attributes, @ModelAttribute("upload") UploadMultipartFileUtil upload, HttpServletRequest request, HttpServletResponse response) {
        return coacheeRule.update(id, dto, result, attributes, upload, request, response);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
        return coacheeRule.delete(id, attributes);
    }

    @PostMapping("/filter")
    public String filter(RepositoryFilter filter) {
        return "redirect:/coachees" + filterRule.filter(filter);
    }

}
