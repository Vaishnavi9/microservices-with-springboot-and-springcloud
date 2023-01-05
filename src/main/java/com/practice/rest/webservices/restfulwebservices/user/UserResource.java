package com.practice.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUserWithId(@PathVariable Integer id){
        User user = userDaoService.findByUserId(id);
        if (user == null ) {
            throw new UserNotFoundException("id: "+id);
        }
        return user;
    }

    @DeleteMapping("/users/{id}")
    public User deleteUserWithId(@PathVariable Integer id){
        User user = userDaoService.findByUserId(id);
        if(user == null) {
            throw new UserNotFoundException("id: "+id);
        } else {
            userDaoService.deleteByUserId(id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.createNewUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();
        return ResponseEntity.created(location).build();

    }
}
