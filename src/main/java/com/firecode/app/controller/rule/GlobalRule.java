package com.firecode.app.controller.rule;

import com.firecode.app.controller.security.AppUserSecurity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.firecode.app.controller.util.PathUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GlobalRule {

    @Autowired
    private PathUtil pathUtil;

    public Model model(Model model, AppUserSecurity appUserSecurity) {
        String avatarUserSystem = pathUtil.getPathAvatarUserDylan();
        String avatarTeamSystem = pathUtil.getPathAvatarTeamSystem();
        model.addAttribute("avatarUserSystem", avatarUserSystem);
        model.addAttribute("avatarTeamSystem", avatarTeamSystem);
        model.addAttribute("footerLink", "https://firecodesystems.com");
        model.addAttribute("footerName", "Firecode Systems");
        model.addAttribute("loggedUser", appUserSecurity);
        model.addAllAttributes(this.listUrl(model));
        return model;
    }

    private Collection<Model> listUrl(Model model) {
        List<Model> list = new ArrayList<>();
        model.addAttribute("coachees", "/coachees");
        model.addAttribute("sessionExperimental", "#");
        model.addAttribute("teamCoaching", "/team/coaching");
        model.addAttribute("schedules", "/schedules");
        model.addAttribute("exercises", "/exercises");
        model.addAttribute("assessments", "/assessments");
        model.addAttribute("messages", "/messages");
        model.addAttribute("reports", "/reports");
        model.addAttribute("personalWebsite", "/site");
        model.addAttribute("observatories", "/observatories");
        model.addAttribute("bonus", "/bonus");
        model.addAttribute("tutorials", "/tutorials");
        model.addAttribute("contactus", "/contactus");

        list.add(model);

        return list;
    }

}
