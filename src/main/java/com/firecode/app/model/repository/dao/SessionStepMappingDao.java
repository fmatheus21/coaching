package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.SessionEntity;
import com.firecode.app.model.entity.SessionStepMappingEntity;
import com.firecode.app.model.repository.SessionStepMappingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fmatheus
 */

@Component
public class SessionStepMappingDao implements GenericDao<SessionStepMappingEntity> {

    @Autowired
    private SessionStepMappingRepository repository;

    @Override
    public void create(SessionStepMappingEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(SessionStepMappingEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SessionStepMappingEntity> findAll(String orderBy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SessionStepMappingEntity findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<SessionStepMappingEntity> findByIdSession(SessionEntity t) {
        return repository.findByIdSession(t);
    }

}
