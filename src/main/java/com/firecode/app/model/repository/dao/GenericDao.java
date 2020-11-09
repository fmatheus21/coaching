package com.firecode.app.model.repository.dao;

public interface GenericDao<T> {

    void create(T t);

    void update(T t);

    Iterable<T> findAll(String orderBy);

    T findById(int id);

    void deleteById(int id);

}
