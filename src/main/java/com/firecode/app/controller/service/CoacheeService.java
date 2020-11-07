package com.firecode.app.controller.service;

import com.firecode.app.model.repository.dao.impl.CoacheeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoacheeService  {
    
    @Autowired private CoacheeDaoImpl coacheeDaoImpl;

    public void search() {

    }

}
