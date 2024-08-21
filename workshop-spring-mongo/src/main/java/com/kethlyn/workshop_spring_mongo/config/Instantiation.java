package com.kethlyn.workshop_spring_mongo.config;

import com.kethlyn.workshop_spring_mongo.domain.User;
import com.kethlyn.workshop_spring_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "maria", "maria@gmail.com");
        User joao = new User(null, "joao", "joao@gmail.com");
        User bentinho = new User(null, "bentinho", "bentinho@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, joao, bentinho));
    }
}
