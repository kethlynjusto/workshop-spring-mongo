package com.kethlyn.workshop_spring_mongo.services;

import com.kethlyn.workshop_spring_mongo.domain.User;
import com.kethlyn.workshop_spring_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {

        return repo.findAll();

    }
}
