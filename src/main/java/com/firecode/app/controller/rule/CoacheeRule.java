package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.CoacheeDto;
import com.firecode.app.controller.service.CoacheeService;
import com.firecode.app.controller.service.ContactService;
import com.firecode.app.controller.service.PersonService;
import com.firecode.app.controller.service.UserService;
import com.firecode.app.controller.util.AppUtil;
import com.firecode.app.controller.util.MessageValidationUtil;
import com.firecode.app.controller.util.PathUtil;
import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.ContactEntity;
import com.firecode.app.model.entity.PersonEntity;
import com.firecode.app.model.entity.UserEntity;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class CoacheeRule {

    @Autowired
    private PathUtil pathUtil;

    @Autowired
    private PersonService personService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private CoacheeService coacheeService;

    @Autowired
    private MessageValidationUtil messageValidationUtil;

    @Autowired
    private CookieRule cookieRule;

    @Autowired
    private UserService userService;

    private CoacheeDto coacheeDto;

    public CoacheeDto init(HttpServletRequest request, HttpServletResponse response) {
        if (cookieRule.readerCookie(request, response) == null) {
            return coacheeDto = new CoacheeDto();
        }
        return coacheeDto;
    }

    private String avatar() {
        return pathUtil.getPathAvatarUserSystem();
    }

    public String create(CoacheeDto dto, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response) {

        String redirect = "redirect:/coachees/create";

        if (result.hasErrors()) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorRequired());
            return this.errorRedirect(dto, request, response);
        }

        PersonEntity person = personService.findBycpfCnpj(AppUtil.removeSpecialCharacters(dto.getCpf()));
        if (person != null) {
            if (person.getCoacheeEntity() != null) {
                attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), "O CPF informado já está cadastrado!");
                return this.errorRedirect(dto, request, response);
            }
        }

        ContactEntity contact = contactService.findByEmail(dto.getEmail());
        if (contact != null) {
            if (contact.getIdPerson().getCoacheeEntity() != null) {
                attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), "O email informado já está cadastrado!");
                return this.errorRedirect(dto, request, response);
            }
        }

        try {
            coacheeDto = new CoacheeDto();
            personService.create(coacheeDto.create(dto, userService.loggedUser()));
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCreate());
            cookieRule.deleteCookie(request, response);
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), ex.getMessage());
        }

        return redirect;

    }

    public String update(int id, CoacheeDto dto, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response) {

        String redirect = "redirect:/coachees/update/" + id;

        if (result.hasErrors()) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorRequired());
            return this.errorRedirect(dto, request, response);
        }

        CoacheeEntity coachee = coacheeService.findById(id);
        if (coachee == null) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorNotFound());
            return "redirect:/coachees";
        }

        try {
            coacheeDto = new CoacheeDto();
            PersonEntity person = coacheeDto.update(coachee.getIdPerson(), dto, userService.loggedUser());
            personService.create(person);
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCreate());
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), "O CPF ou email já está cadastrado.");
        }

        return redirect;

    }

    private String errorRedirect(CoacheeDto dto, HttpServletRequest request, HttpServletResponse response) {
        String redirect = "redirect:/coachees/create";
        coacheeDto = dto;
        cookieRule.createCookie(request, response);
        return redirect;
    }

    public List<CoacheeDto> listAll() {
        coacheeDto = new CoacheeDto();
        List<CoacheeEntity> list = coacheeService.findAll("id");
        return coacheeDto.reader(list, this.avatar());
    }

    public CoacheeDto findById(int id) {
        coacheeDto = new CoacheeDto();
        CoacheeEntity coachee = coacheeService.findById(id);
        if (coachee == null) {
            return null;
        }
        return coacheeDto.find(coachee, this.avatar());
    }

    public String delete(int id, RedirectAttributes attributes) {

        String redirect = "redirect:/coachees";

        CoacheeEntity coachee = coacheeService.findById(id);

        if (coachee == null) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorNotFound());
            return redirect;
        }

        try {
            personService.deleteById(coachee.getIdPerson().getId());
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCreate());
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), ex.getMessage());
        }
        return redirect;

    }

}
