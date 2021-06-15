package com.example.helloworld.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class ClientConfig {

    @Value("${endpoint.baseUri}")
    private String baseUri;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(baseUri)
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUri));
        return restTemplate;
    }
}
