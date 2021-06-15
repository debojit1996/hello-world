package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/worldWeb")
    public String helloWorldSynchronous() {
        return "Hello World";
    }

    @GetMapping("worldReactiveWeb")
    public Mono<String> helloWorldAsynchronous() {
        return Mono.just("Hello Reactive World");
    }
}
