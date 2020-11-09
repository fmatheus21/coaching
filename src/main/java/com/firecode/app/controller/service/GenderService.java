package com.firecode.app.controller.service;

import com.firecode.app.model.entity.GenderEntity;
import com.firecode.app.model.repository.dao.GenderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService {

    @Autowired
    private GenderDao dao;

    public Iterable<GenderEntity> findAll(String orderBy) {
        return dao.findAll(orderBy);
    }

}
