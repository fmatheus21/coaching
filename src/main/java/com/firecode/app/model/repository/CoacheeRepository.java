package com.firecode.app.model.repository;

import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.repository.query.CoacheeRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoacheeRepository extends JpaRepository<CoacheeEntity, Integer>, CoacheeRepositoryQuery {

}
