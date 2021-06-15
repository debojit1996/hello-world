package com.example.helloworld.base.controller;

import com.example.helloworld.base.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class HelloWorldControllerTest extends BaseTest {
    @Autowired
    private WebClient webClient;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void testHelloWorldSynchronous() {
        Assertions.assertThat(this.restTemplate.getForObject( "/worldWeb", String.class))
                .contains("Hello World");
    }

    @Test
    void testHelloWorldAsynchronous() {
        Mono<String> helloWorldResponse = this.webClient.get()
                .uri("/worldReactiveWeb")
                .retrieve()
                .bodyToMono(String.class);

        StepVerifier.create(helloWorldResponse)
                .expectNext("Hello Reactive World")
                .verifyComplete();
    }
}
