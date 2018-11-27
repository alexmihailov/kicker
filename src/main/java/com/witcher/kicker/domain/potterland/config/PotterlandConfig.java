package com.witcher.kicker.domain.potterland.config;

import com.witcher.kicker.domain.potterland.service.PotterlandService;
import com.witcher.kicker.domain.potterland.service.PotterlandServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class PotterlandConfig {

    @Bean(name = "potterland_rest_template")
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("173.165.143.157", 60592));
        factory.setProxy(proxy);
        return new RestTemplate(factory);
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
