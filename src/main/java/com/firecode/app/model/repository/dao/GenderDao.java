package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.GenderEntity;
import com.firecode.app.model.repository.GenderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class GenderDao implements GenericDao<GenderEntity> {

    @Autowired
    private GenderRepository repository;

    @Override
    public GenderEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Iterable<GenderEntity> findAll(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

    @Override
    public void create(GenderEntity t) {
        repository.save(t);
    }

    @Override
    public void update(GenderEntity t) {
        repository.save(t);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
