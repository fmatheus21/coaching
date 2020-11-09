package com.firecode.app.controller.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageValidationUtil {

    @Getter
    @Setter
    @Value("${attribute.error}")
    private String attributeError;

    @Getter
    @Setter
    @Value("${attribute.success}")
    private String attributeSuccess;

    @Getter
    @Setter
    @Value("${attribute.alert}")
    private String attributeAlert;

    @Getter
    @Setter
    @Value("${error.required}")
    private String errorRequired;

    @Getter
    @Setter
    @Value("${error.notfound}")
    private String errorNotFound;

    @Getter
    @Setter
    @Value("${success.create}")
    private String successCreate;

    @Getter
    @Setter
    @Value("${success.delete}")
    private String successDelete;

    @Getter
    @Setter
    @Value("${error.register.exist}")
    private String errorRegisterExist;

    @Getter
    @Setter
    @Value("${success.activate.notice}")
    private String successActivateNotice;

    @Getter
    @Setter
    @Value("${error.notpermission}")
    private String errorNotPermission;

    @Getter
    @Setter
    @Value("${error.delete.register.exist}")
    private String errorDeleteRegisterExist;

}
