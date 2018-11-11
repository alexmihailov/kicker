package com.witcher.kicker.domain.potterland.config;

import com.witcher.kicker.domain.potterland.service.PotterlandService;
import com.witcher.kicker.domain.potterland.service.PotterlandServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PotterlandConfig {

    @Bean(name = "potterland_rest_template")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PotterlandService potterlandService() {
        return new PotterlandServiceImpl();
    }

    @Bean(name = "potterland_headers")
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }
}
