package com.kethlyn.workshop_spring_mongo.services;

import com.kethlyn.workshop_spring_mongo.domain.User;
import com.kethlyn.workshop_spring_mongo.repository.UserRepository;
import com.kethlyn.workshop_spring_mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {

        return repo.findAll();
    }

    public User findbyId(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }
}
