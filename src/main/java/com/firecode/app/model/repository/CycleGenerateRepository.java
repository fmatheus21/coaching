package com.firecode.app.model.repository;

import com.firecode.app.model.entity.CycleGenerateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fmatheus
 */
public interface CycleGenerateRepository extends JpaRepository<CycleGenerateEntity, Integer> {

    public CycleGenerateEntity findByCycleCoache(int value);

}
