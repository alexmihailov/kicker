package com.witcher.kicker.domain.kupipotter.config;

import com.witcher.kicker.domain.kupipotter.service.KupipotterService;
import com.witcher.kicker.domain.kupipotter.service.KupipotterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class KupipotterConfig {

    @Bean(name = "kupipotter_rest_template")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public KupipotterService kupipotterService() {
        return new KupipotterServiceImpl();
    }

    @Bean(name = "kupipotter_header")
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
