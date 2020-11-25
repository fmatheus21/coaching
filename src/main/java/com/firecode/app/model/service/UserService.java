package com.firecode.app.model.service;

import com.firecode.app.model.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserEntity loggedUser() {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setUser("fmatheus");
        return user;
    }

}
