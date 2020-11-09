package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.CoacheeDto;
import com.firecode.app.controller.service.CoacheeService;
import com.firecode.app.controller.service.PersonService;
import com.firecode.app.controller.util.MessageValidationUtil;
import com.firecode.app.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class CoacheeRule {

    @Autowired
    private PersonService personService;

    @Autowired
    private CoacheeService coacheeService;

    @Autowired
    private MessageValidationUtil messageValidationUtil;

    private CoacheeDto coacheeDto;

    public CoacheeDto init() {
        return coacheeDto = new CoacheeDto();
    }

    public String create(CoacheeDto dto, BindingResult result, RedirectAttributes attributes) {

        String redirect = "redirect:/coachees/create";
     
        if (result.hasErrors()) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorRequired());

            return redirect;
        }

        coacheeDto = new CoacheeDto();

        try {
            personService.create(coacheeDto.create(dto, new UserEntity(1)));
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCreate());
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), ex.getMessage());
        }

        return redirect;

    }

}
