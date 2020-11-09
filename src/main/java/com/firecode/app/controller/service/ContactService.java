package com.firecode.app.controller.service;

import com.firecode.app.model.entity.ContactEntity;
import com.firecode.app.model.repository.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactDao dao;

    public ContactEntity findByEmail(String value) {
        return dao.findByEmail(value);
    }

}
