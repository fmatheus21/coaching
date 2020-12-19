package com.firecode.app.controller.dto;

import com.firecode.app.controller.util.AppUtil;
import com.firecode.app.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

public class UserDto {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String firstCaracter;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String avatar;

    public static UserDto converterObject(UserEntity user, String path) {
        UserDto dto = new UserDto();
        String name = user.getIdPerson().getNameCompanyname();
        dto.setId(user.getId());
        dto.setUserName(user.getUsername());
        dto.setFirstName(AppUtil.returnFirstWord(name));
        dto.setFirstCaracter(AppUtil.returnCharacter(name, 1));
        dto.setEmail(user.getIdPerson().getContactEntity().getEmail());
        dto.setAvatar(path + user.getAvatar());
        return dto;
    }

}
