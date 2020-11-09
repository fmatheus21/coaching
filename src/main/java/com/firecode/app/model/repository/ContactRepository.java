package com.firecode.app.model.repository;

import com.firecode.app.model.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

    ContactEntity findByEmail(String value);

}
