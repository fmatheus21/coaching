package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.SessionGenerateMindfulnessDto;
import com.firecode.app.controller.security.AppUserSecurity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fmatheus
 */

@Component
public class SessionGenerateRule {
    
    public String createSessionGenerateMindfulness(
            SessionGenerateMindfulnessDto dto, 
            BindingResult result, 
            RedirectAttributes attributes, 
            AppUserSecurity appUserSecurity){
        
      /*   try {
            var dto=new SessionGenerateMindfulnessDto();
            personService.create(coacheeDto.create(dto, new UserEntity(appUserSecurity.getIdUser()), fileName));
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCreate());
            cookieRule.deleteCookie(request, response);
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), ex.getMessage());
        }*/
        
        return null;
    }
    
}
