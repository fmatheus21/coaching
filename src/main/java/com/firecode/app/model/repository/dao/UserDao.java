package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.UserEntity;
import com.firecode.app.model.repository.UserRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements GenericDao<UserEntity> {

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<UserEntity> findAll(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

    @Override
    public void create(UserEntity t) {
        repository.save(t);
    }

    @Override
    public void update(UserEntity t) {
        repository.save(t);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Optional<UserEntity> findByUser(String value) {
        return repository.findByUser(value);
    }

}
