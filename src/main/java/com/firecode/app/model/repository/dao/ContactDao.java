package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.ContactEntity;
import com.firecode.app.model.repository.ContactRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class ContactDao implements GenericDao<ContactEntity> {

    @Autowired
    private ContactRepository repository;

    @Override
    public ContactEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ContactEntity> findAll(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

    @Override
    public void create(ContactEntity t) {
        repository.save(t);
    }

    @Override
    public void update(ContactEntity t) {
        repository.save(t);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ContactEntity findByEmail(String value) {
        return repository.findByEmail(value);
    }

}
