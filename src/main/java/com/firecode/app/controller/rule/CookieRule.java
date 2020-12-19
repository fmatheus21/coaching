package com.firecode.app.controller.rule;

import com.firecode.app.model.service.UserService;
import com.firecode.app.model.entity.UserEntity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CookieRule {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSessionRule userSessionRule;

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Cookie createCookie(HttpServletRequest request, HttpServletResponse response) {

        String userSession = this.userSessionRule.authentication();
        UserEntity user = userService.findByUser(userSession).orElse(null);
        Cookie cookie = null;
        String cookieName = user.getUsername();
        String cookieValue = String.valueOf(user.getId());

        if (this.readerCookie(request, response) == null) {
            try {
                cookie = new Cookie(cookieName, URLEncoder.encode(cookieValue, "UTF-8"));
                cookie.setMaxAge(60 * 60 * 24); // 24 hour
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
                System.out.println("Create Cookie: " + cookie.getName());
            } catch (UnsupportedEncodingException e) {
                logger.log(Level.WARNING, "Error create cookie: " + e.getMessage());
            }
        }

        return cookie;
    }

    public Cookie deleteCookie(HttpServletRequest request, HttpServletResponse response) {

        String cookieName = this.userSessionRule.authentication();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    System.out.println("Delete Cookie: " + cookie.getName());
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    return cookie;
                }
            }
        }
        return null;
    }

    public Cookie readerCookie(HttpServletRequest request, HttpServletResponse response) {
        String cookieName = this.userSessionRule.authentication();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("Reader Cookie: " + cookie.getName());
                if (cookie.getName().equals(cookieName)) {
                    System.out.println("Cookie Encontrado: " + cookie.getName());
                    return cookie;
                }
            }
        }
        return null;
    }

}
