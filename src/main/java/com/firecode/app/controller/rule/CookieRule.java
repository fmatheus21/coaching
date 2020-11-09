
package com.firecode.app.controller.rule;

import com.firecode.app.controller.service.UserService;
import com.firecode.app.model.entity.UserEntity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CookieRule {
    
    @Autowired
    private UserService userService;
    
    public Cookie readerCookie(HttpServletRequest request, HttpServletResponse response) {
        UserEntity user = userService.loggedUser();
        String cookieName = user.getUser();
        String cookieValue = user.getUser();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    System.out.println("Reader Cookie: "+cookie.getName());
                    return cookie;
                }
            }
        }
        return null;
    }

    public Cookie createCookie(HttpServletRequest request, HttpServletResponse response) {

        UserEntity user = userService.loggedUser();
        Cookie cookie = null;
        String cookieName = user.getUser();
        String cookieValue = user.getUser();

        try {
            cookie = new Cookie(cookieName, URLEncoder.encode(cookieValue, "UTF-8"));
            cookie.setMaxAge(60 * 60 * 24); // 24 hour
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
             System.out.println("Create Cookie: "+cookie.getName());
        } catch (UnsupportedEncodingException e) {
        }

        return cookie;
    }

    public Cookie deleteCookie(HttpServletRequest request, HttpServletResponse response) {
        UserEntity user = userService.loggedUser();
        String cookieName = user.getUser();
        String cookieValue = user.getUser();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                     System.out.println("Delete Cookie: "+cookie.getName());
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);      
                    return cookie;
                }
            }
        }
        return null;
    }
    
}
