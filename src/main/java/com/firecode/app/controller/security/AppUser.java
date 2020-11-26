package com.firecode.app.controller.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.firecode.app.model.entity.UserEntity;

public class AppUser extends User {

    private final UserEntity user;

    public AppUser(UserEntity user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUser(), user.getPassword(), authorities);
        this.user = user;       
    }

    public UserEntity getUser() {
        return user;
    }

}
