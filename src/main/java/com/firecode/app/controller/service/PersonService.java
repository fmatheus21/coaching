package com.firecode.app.controller.service;

import com.firecode.app.model.entity.PersonEntity;
import com.firecode.app.model.repository.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonDao dao;

    public void create(PersonEntity person) {
        dao.create(person);
    }

    public PersonEntity findBycpfCnpj(String value) {
        return dao.findByCpfCnpj(value);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

}
