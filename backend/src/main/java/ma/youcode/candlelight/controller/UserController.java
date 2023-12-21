package ma.youcode.candlelight.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import ma.youcode.candlelight.models.documents.User;
import ma.youcode.candlelight.repositories.UserRepository;

@AllArgsConstructor

@Controller
public class UserController {
    
    private final UserRepository repository;

    @QueryMapping
    List<User> users() {
        return repository.findAll();
    }

    @QueryMapping
    User userById(@Argument String id) {
        return repository.findById(id).get();
    }

    @MutationMapping
    User addUser(@Argument User userToAdd) {
        
    }
}
