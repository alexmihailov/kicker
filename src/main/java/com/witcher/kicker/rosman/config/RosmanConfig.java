package com.witcher.kicker.rosman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RosmanConfig {

    @Bean(name = "rosman_rest_template")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "rosman_headers")
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }
}
