package com.firecode.app.model.service;

import com.firecode.app.model.entity.ExerciseMindfulnessEntity;
import com.firecode.app.model.repository.dao.ExerciseMindfulnessDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fmatheus
 */
@Service
public class ExerciseMindfulnessService {

    @Autowired
    private ExerciseMindfulnessDao dao;

    public List<ExerciseMindfulnessEntity> findAll(String orderBy) {
        return dao.findAll(orderBy);

    }

}
