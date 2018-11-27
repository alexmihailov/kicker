package com.witcher.kicker.domain.kupipotter.config;

import com.witcher.kicker.domain.kupipotter.service.KupipotterService;
import com.witcher.kicker.domain.kupipotter.service.KupipotterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class KupipotterConfig {

    @Bean(name = "kupipotter_rest_template")
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("173.165.143.157", 60592));
        factory.setProxy(proxy);
        return new RestTemplate(factory);
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
