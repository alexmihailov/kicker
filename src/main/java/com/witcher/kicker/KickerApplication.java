package com.witcher.kicker;

import com.witcher.kicker.email.service.MailService;
import com.witcher.kicker.kupipotter.service.KupipotterService;
import com.witcher.kicker.kupipotter.service.KupipotterServiceImpl;
import com.witcher.kicker.potterland.service.PotterlandService;
import com.witcher.kicker.rosmean.service.RosmeanService;
import com.witcher.kicker.zigzag.service.ZigzagService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KickerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KickerApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(KupipotterService kupipotterService,
								 PotterlandService potterlandService,
								 MailService mailService,
								 ZigzagService zigzagService,
								 RosmeanService rosmeanService) throws Exception {
		return args -> {
//			kupipotterService.sendKupipotterRequest();
//			potterlandService.sendPotterlandRequest();
//			mailService.sendEmail("Test", "hello");
		};
	}
}
