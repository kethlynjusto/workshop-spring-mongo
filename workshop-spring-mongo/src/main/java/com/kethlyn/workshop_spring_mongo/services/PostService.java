package com.kethlyn.workshop_spring_mongo.services;

import com.kethlyn.workshop_spring_mongo.domain.Post;
import com.kethlyn.workshop_spring_mongo.repository.PostRepository;
import com.kethlyn.workshop_spring_mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }
}
