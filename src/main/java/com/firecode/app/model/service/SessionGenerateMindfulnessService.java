package com.firecode.app.model.service;

import com.firecode.app.model.entity.SessionGenerateMindfulnessEntity;
import com.firecode.app.model.repository.dao.SessionGenerateMindfulnessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fmatheus
 */
@Service
public class SessionGenerateMindfulnessService {

    @Autowired
    private SessionGenerateMindfulnessDao dao;

    public void create(SessionGenerateMindfulnessEntity t) {
        dao.create(t);
    }

}
