package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.repository.CoacheeRepository;
import com.firecode.app.model.repository.filter.RepositoryFilter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class CoacheeDao implements GenericDao<CoacheeEntity> {

    @Autowired
    private CoacheeRepository repository;

    @Override
    public  CoacheeEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CoacheeEntity> findAll(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

    @Override
    public void create(CoacheeEntity t) {
        repository.save(t);
    }

    @Override
    public void update(CoacheeEntity t) {
        repository.save(t);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Page<CoacheeEntity> findAllPaginator(RepositoryFilter filter, Pageable pageable) {
        return repository.findAllPaginator(filter, pageable);
    }

}
