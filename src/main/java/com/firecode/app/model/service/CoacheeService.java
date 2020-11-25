package com.firecode.app.model.service;

import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.repository.dao.CoacheeDao;
import com.firecode.app.model.repository.filter.RepositoryFilter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoacheeService {

    @Autowired
    private CoacheeDao dao;

    public Page<CoacheeEntity> findAllPaginator(RepositoryFilter filter, Pageable pageable) {
        return dao.findAllPaginator(filter, pageable);
    }

    public List<CoacheeEntity> findAll(String orderBy) {
        return dao.findAll(orderBy);
    }

    public CoacheeEntity findById(int id) {
        return dao.findById(id);
    }

}
