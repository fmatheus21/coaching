package com.firecode.app.model.service;

import com.firecode.app.model.entity.CycleEntity;
import com.firecode.app.model.repository.dao.CycleDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fmatheus
 */
@Service
public class CycleService {

    @Autowired
    private CycleDao dao;

    public List<CycleEntity> findAll(String orderBy) {
        return dao.findAll(orderBy);
    }

}
