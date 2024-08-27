package com.kethlyn.workshop_spring_mongo.config;

import com.kethlyn.workshop_spring_mongo.domain.Post;
import com.kethlyn.workshop_spring_mongo.domain.User;
import com.kethlyn.workshop_spring_mongo.dto.AuthorDTO;
import com.kethlyn.workshop_spring_mongo.dto.CommentDTO;
import com.kethlyn.workshop_spring_mongo.repository.PostRepository;
import com.kethlyn.workshop_spring_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "maria", "maria@gmail.com");
        User joao = new User(null, "joao", "joao@gmail.com");
        User bentinho = new User(null, "bentinho", "bentinho@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, joao, bentinho));

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"Patiu Viagem", "Vou viajar para São Paulo. Abracos!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("24/09/2018"),"Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("21/03/2018"), new AuthorDTO(bentinho));
        CommentDTO c2 = new CommentDTO("Bora Bil", sdf.parse("23/03/2018"), new AuthorDTO(joao));
        CommentDTO c3 = new CommentDTO("É isso ai", sdf.parse("24/09/2018"), new AuthorDTO(bentinho));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
