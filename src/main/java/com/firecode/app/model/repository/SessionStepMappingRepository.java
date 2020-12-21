package com.firecode.app.model.repository;

import com.firecode.app.model.entity.SessionEntity;
import com.firecode.app.model.entity.SessionStepMappingEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fmatheus
 */
@Repository
public interface SessionStepMappingRepository extends JpaRepository<SessionStepMappingEntity, Integer> {

    List<SessionStepMappingEntity> findByIdSession(SessionEntity t);
}
