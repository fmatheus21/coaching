package com.firecode.app.controller.rule;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserSessionRule {

    protected String authentication() {

        SecurityContext context = SecurityContextHolder.getContext();
        String user = null;

        if (context instanceof SecurityContext) {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                if (!authentication.getName().equalsIgnoreCase("anonymousUser")) { // Se o usuario logado nao for
                    // anonimo
                    user = ((User) authentication.getPrincipal()).getUsername();
                    System.out.println("Usuario:" + user);
                    System.out.println("Autorização: "
                            + authentication.getAuthorities().toString().replaceAll("\\[", "").replaceAll("\\]", ""));
                }
            }
        }

        return user;
    }

}
