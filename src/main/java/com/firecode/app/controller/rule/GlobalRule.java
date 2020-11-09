package com.firecode.app.controller.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.firecode.app.controller.util.PathUtil;

@Service
public class GlobalRule {

    @Autowired
    private PathUtil pathUtil;

    public Model model(Model model) {
        String avatarUserSystem = pathUtil.getPathAvatarUserSystem();
         String avatarTeamSystem = pathUtil.getPathAvatarTeamSystem();
        model.addAttribute("avatarUserSystem", avatarUserSystem);
        model.addAttribute("avatarTeamSystem", avatarTeamSystem);
        model.addAttribute("footerLink", "https://firecodesystems.com");
        model.addAttribute("footerName", "Firecode Systems");
        return model;
    }

}
