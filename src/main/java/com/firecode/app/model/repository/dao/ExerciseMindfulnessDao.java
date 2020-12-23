package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.ExerciseMindfulnessEntity;
import com.firecode.app.model.repository.ExerciseMindfulnessRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 *
 * @author fmatheus
 */

@Component
public class ExerciseMindfulnessDao implements GenericDao<ExerciseMindfulnessEntity> {

    @Autowired
    private ExerciseMindfulnessRepository repository;

    @Override
    public void create(ExerciseMindfulnessEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ExerciseMindfulnessEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExerciseMindfulnessEntity> findAll(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

    @Override
    public ExerciseMindfulnessEntity findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
