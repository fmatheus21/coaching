package com.firecode.app.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.firecode.app.controller.util.PathUtil;

@Service
public class GlobalService {

    @Autowired
    private PathUtil pathUtil;

    public Model model(Model model) {
        String avatarSystem = pathUtil.getPathAvatarSystem();
        model.addAttribute("avatarSystem", avatarSystem);
        model.addAttribute("footerLink", "https://firecodesystems.com");
        model.addAttribute("footerName", "Firecode Systems");
        return model;
    }

}
