package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.CoacheeEntity;
import java.util.List;

public interface CoacheeDao {

    void create(CoacheeEntity entity);

    void update(CoacheeEntity entity);

    List< CoacheeEntity> findAll(String orderBy);

    CoacheeEntity findById(int id);

    void deleteById(int id);

}
