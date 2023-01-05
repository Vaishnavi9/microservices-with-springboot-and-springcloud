package com.practice.rest.webservices.restfulwebservices.helloworld;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

// Expose REST API
@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController (MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    // Give a specific URI /hello-world
    // GEt mapping annotation works same as above
    @RequestMapping(method = RequestMethod.GET, path="hello-world")
    public String helloWorld() {
        return "hello world request mapping get method";
    }
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

    @RequestMapping(method = RequestMethod.GET, path="hello-world-internationalized")
    public String helloWorldInternationalize() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

    }
}
