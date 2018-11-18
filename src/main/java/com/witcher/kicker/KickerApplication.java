package com.witcher.kicker;

import com.witcher.kicker.email.service.MailService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KickerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KickerApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(MailService mailService) {
		return args -> mailService.sendEmailStartApp();
	}
}
