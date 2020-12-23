package com.firecode.app.controller.dto;

import com.firecode.app.model.entity.SessionEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fmatheus
 */
public class SessionDto {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;

    public static SessionDto converterObject(SessionEntity session) {

        var sessionDto = new SessionDto();
        sessionDto.setId(session.getId());
        sessionDto.setName(session.getName());

        return sessionDto;
    }

}
