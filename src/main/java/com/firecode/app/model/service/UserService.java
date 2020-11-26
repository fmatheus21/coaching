package com.firecode.app.model.service;

import com.firecode.app.model.entity.UserEntity;
import com.firecode.app.model.repository.dao.UserDao;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public Optional<UserEntity> findByUser(String value) {
        return dao.findByUser(value);
    }

}
