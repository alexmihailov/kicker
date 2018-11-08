package com.witcher.kicker.email.config;

import com.witcher.kicker.email.service.MailService;
import com.witcher.kicker.email.service.MailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {

    @Bean
    public MailService mailService() {
        return new MailServiceImpl();
    }
}
