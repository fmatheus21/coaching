package com.firecode.app.controller.security;

import com.firecode.app.controller.util.AppUtil;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.firecode.app.model.entity.UserEntity;

public class AppUserSecurity extends User {

    private final UserEntity user;

    public AppUserSecurity(UserEntity user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public int getIdUser() {
        return user.getId();
    }

    public String getFirstName() {
        String name = user.getIdPerson().getNameCompanyname();
        return AppUtil.returnFirstWord(name);
    }

    public String getFirstCaracter() {
        String name = user.getIdPerson().getNameCompanyname();
        return AppUtil.returnCharacter(name, 1);
    }

    public String getRole() {
        return user.getUserPermissionMappingEntity().getIdPermission().getName();
    }

    public String getAvatar() {
        return "/app/upload/avatar/user/" + user.getAvatar();
    }

    public String getEmail() {
        return user.getIdPerson().getContactEntity().getEmail();
    }

}
