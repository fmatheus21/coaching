package com.firecode.app.model.service;

import com.firecode.app.model.entity.SessionEntity;
import com.firecode.app.model.entity.SessionStepMappingEntity;
import com.firecode.app.model.repository.dao.SessionStepMappingDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fmatheus
 */

@Service
public class SessionStepMappingService {

    @Autowired
    private SessionStepMappingDao dao;

    public List<SessionStepMappingEntity> findByIdSession(SessionEntity t) {
        return dao.findByIdSession(t);
    }

}
