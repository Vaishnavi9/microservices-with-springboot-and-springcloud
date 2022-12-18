package com.practice.rest.webservices.restfulwebservices.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Expose REST API
@RestController
public class HelloWorld {
    // Give a specific URI /hello-world
    @GetMapping("hello-world")
    public String helloWorld() {
        return "hello world";
    }
}
