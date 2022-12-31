package com.practice.rest.webservices.restfulwebservices.helloworld;


import org.springframework.web.bind.annotation.*;

// Expose REST API
@RestController
public class HelloWorld {
    // Give a specific URI /hello-world
    @RequestMapping(method = RequestMethod.GET, path="hello-world")
    public String helloWorld() {
        return "hello world request mapping get method";
    }
    // GEt mapping annotation works same as above
    @GetMapping("hello-world-new")
    public String helloWorldGetMapping() {
        return "hello world get mapping annotation";
    }

    // GEt mapping annotation to return a java bean
    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldReturnBean() {
        return new HelloWorldBean("hello world get mapping annotation");
    }

    // GEt mapping annotation to understand path variable
    @GetMapping("path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Welcome to the new world %s",name));
    }
}
