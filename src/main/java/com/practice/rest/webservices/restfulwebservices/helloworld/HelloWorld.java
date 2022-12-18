package com.practice.rest.webservices.restfulwebservices.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
