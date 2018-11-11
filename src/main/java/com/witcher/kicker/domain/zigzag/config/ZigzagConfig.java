package com.witcher.kicker.domain.zigzag.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ZigzagConfig {

    @Bean(name = "zigzag_rest_template")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "zigzag_header")
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
