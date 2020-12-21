package com.firecode.app.model.service;

import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.CycleEntity;
import com.firecode.app.model.entity.CycleGenerateEntity;
import com.firecode.app.model.repository.dao.CycleGenerateDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fmatheus
 */
@Service
public class CycleGenerateService {

    @Autowired
    private CycleGenerateDao dao;

    public void create(CycleGenerateEntity t) {
        dao.create(t);
    }

    public CycleGenerateEntity findByCycleCoache(int value) {
        return dao.findByCycleCoache(value);
    }

    public List<CycleGenerateEntity> findByIdCoachee(CoacheeEntity t) {
        return dao.findByIdCoachee(t);
    }

    public CycleGenerateEntity findByIdCoacheeAndIdCycle(CoacheeEntity coachee, CycleEntity cycle) {
        return dao.findByIdCoacheeAndIdCycle(coachee, cycle);
    }

}
