package com.firecode.app.model.repository;

import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.CycleEntity;
import com.firecode.app.model.entity.CycleGenerateEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fmatheus
 */
public interface CycleGenerateRepository extends JpaRepository<CycleGenerateEntity, Integer> {

    CycleGenerateEntity findByCycleCoache(int value);

    List<CycleGenerateEntity> findByIdCoachee(CoacheeEntity t);

    CycleGenerateEntity findByIdCoacheeAndIdCycle(CoacheeEntity coachee, CycleEntity cycle);

}
