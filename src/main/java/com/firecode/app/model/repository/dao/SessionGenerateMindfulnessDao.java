package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.SessionGenerateMindfulnessEntity;
import com.firecode.app.model.repository.SessionGenerateMindfulnessRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 *
 * @author fmatheus
 */
@Component
public class SessionGenerateMindfulnessDao implements GenericDao<SessionGenerateMindfulnessEntity> {

    @Autowired
    private SessionGenerateMindfulnessRepository repository;

    @Override
    public void create(SessionGenerateMindfulnessEntity t) {
        repository.save(t);
    }

    @Override
    public void update(SessionGenerateMindfulnessEntity t) {
        repository.save(t);
    }

    @Override
    public List<SessionGenerateMindfulnessEntity> findAll(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

    @Override
    public SessionGenerateMindfulnessEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
