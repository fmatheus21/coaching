package com.firecode.app.controller.service;

import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.repository.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoacheeService {

    @Autowired
    private GenericDao<CoacheeEntity> dao;

    public Iterable<CoacheeEntity> findAll(String orderBy) {
        return dao.findAll(orderBy);
    }

}
