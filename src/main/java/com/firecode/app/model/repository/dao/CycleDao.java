package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.CycleEntity;
import com.firecode.app.model.repository.CycleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 *
 * @author fmatheus
 */
@Component
public class CycleDao implements GenericDao<CycleEntity> {

    @Autowired
    private CycleRepository repository;

    @Override
    public void create(CycleEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CycleEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CycleEntity> findAll(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

    @Override
    public CycleEntity findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
