package com.firecode.app.model.repository.dao.impl;

import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.repository.CoacheeRepository;
import com.firecode.app.model.repository.dao.CoacheeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public  abstract class CoacheeDaoImpl implements CoacheeDao {

    @Autowired
    private CoacheeRepository repository;

    @Override
    public void create(CoacheeEntity entity) {
        repository.save(entity);
    }

    @Override
    public void update(CoacheeEntity entity) {
        repository.save(entity);
    }

    @Override
    public List<CoacheeEntity> findAll(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc("orderBy")));
    }

    @Override
    public CoacheeEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
