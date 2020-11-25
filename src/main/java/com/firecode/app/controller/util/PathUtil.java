package com.firecode.app.controller.util;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class PathUtil {

    @Getter
    @Value("${path.static}")
    private String pathStatic;

    @Getter
    @Value("${path.upload}")
    private String pathUpload;

    @Getter
    @Value("${path.logo}")
    private String pathLogo;

    @Getter
    @Value("${path.avatar.coachee}")
    private String pathAvatarCoachee;

    @Getter
    @Value("${path.avatar.user.mary}")
    private String pathAvatarUserMary;
    
     @Getter
    @Value("${path.avatar.user.dylan}")
    private String pathAvatarUserDylan;

    @Getter
    @Value("${path.avatar.team.system}")
    private String pathAvatarTeamSystem;

    @Getter
    @Value("${extension.image}")
    private String extensionImage;

    @Getter
    @Value("${file.size.total}")
    private long fileSizeTotal;

    public String localPath() {
        // return System.getProperty("user.dir");
        return getClass().getClassLoader().getResource("").getPath().replace("%20", " ");
    }

}
