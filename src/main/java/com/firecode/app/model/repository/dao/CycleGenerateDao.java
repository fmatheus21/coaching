package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.CycleEntity;
import com.firecode.app.model.entity.CycleGenerateEntity;
import com.firecode.app.model.repository.CycleGenerateRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fmatheus
 */
@Component
public class CycleGenerateDao implements GenericDao<CycleGenerateEntity> {

    @Autowired
    private CycleGenerateRepository repository;

    @Override
    public void create(CycleGenerateEntity t) {
        repository.save(t);
    }

    @Override
    public void update(CycleGenerateEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CycleGenerateEntity> findAll(String orderBy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CycleGenerateEntity findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CycleGenerateEntity findByCycleCoache(int value) {
        return repository.findByCycleCoache(value);
    }

    public List<CycleGenerateEntity> findByIdCoachee(CoacheeEntity t) {
        return repository.findByIdCoachee(t);
    }

    public CycleGenerateEntity findByIdCoacheeAndIdCycle(CoacheeEntity coachee, CycleEntity cycle) {
        return repository.findByIdCoacheeAndIdCycle(coachee, cycle);
    }

}
