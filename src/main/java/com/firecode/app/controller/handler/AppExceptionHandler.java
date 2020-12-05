package com.firecode.app.controller.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class AppExceptionHandler extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatException(NumberFormatException e, RedirectAttributes attributes) {
        log.info(e.getMessage());
        attributes.addFlashAttribute(e.getMessage());
        return "redirect:/dashboard";
    }

}
