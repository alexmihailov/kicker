package com.witcher.kicker.rosmean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RosmeanConfig {

    @Bean(name = "rosmean_rest_template")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "rosmean_header")
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
