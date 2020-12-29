package com.firecode.app.model.repository;

import com.firecode.app.model.entity.SessionGenerateMindfulnessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fmatheus
 */
@Repository
public interface SessionGenerateMindfulnessRepository extends JpaRepository<SessionGenerateMindfulnessEntity, Integer> {

}
