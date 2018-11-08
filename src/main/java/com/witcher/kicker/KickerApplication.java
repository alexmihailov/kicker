package com.witcher.kicker;

import com.witcher.kicker.kupipotter.service.KupipotterService;
import com.witcher.kicker.kupipotter.service.KupipotterServiceImpl;
import com.witcher.kicker.potterland.service.PotterlandService;
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
								 PotterlandService potterlandService) throws Exception {
		return args -> {
//			kupipotterService.sendKupipotterRequest();
			potterlandService.sendPotterlandRequest();
		};
	}
}