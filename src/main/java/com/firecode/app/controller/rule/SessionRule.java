package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.UserDto;
import com.firecode.app.controller.util.PathUtil;
import com.firecode.app.model.entity.UserEntity;
import com.firecode.app.model.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionRule {

    @Autowired
    private UserSessionRule userSessionRule;

    @Autowired
    private UserService userService;

    @Autowired
    private PathUtil pathUtil;

    private List<UserDto> list;

    private String pathAvatar() {
        return pathUtil.getPathUpload() + pathUtil.getPathAvatarCoachee();
    }
    

    private UserDto readerUser(String userSession) {

        for (UserDto user : list) {
            if (user.getUserName().equalsIgnoreCase(userSession)) {
                System.out.println("User Session: " + user.getUserName());
                return user;
            }
        }

        return null;

    }

}
