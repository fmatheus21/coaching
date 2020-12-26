package com.firecode.app.controller.resource;

import com.firecode.app.controller.dto.SessionGenerateMindfulnessDto;
import com.firecode.app.controller.security.AppUserSecurity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fmatheus
 */
@Controller
@RequestMapping("/session/generate")
public class SessionGenerateResource {

    @PostMapping("/mindfulness")
    public void createMindfulness(
            @Valid SessionGenerateMindfulnessDto dto,
            BindingResult result,
            RedirectAttributes attributes,
            HttpServletRequest request,
            HttpServletResponse response,
            @AuthenticationPrincipal AppUserSecurity appUserSecurity
    ) {
        System.out.println("ID: " + dto.getIdExerciseMindfulness());
    }

}
