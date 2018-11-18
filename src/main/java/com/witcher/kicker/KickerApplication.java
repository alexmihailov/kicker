package com.witcher.kicker;

import com.witcher.kicker.database.pager.CircularPagerService;
import com.witcher.kicker.domain.kupipotter.service.KupipotterRequestBuilderService;
import com.witcher.kicker.email.service.MailService;
import com.witcher.kicker.domain.kupipotter.service.KupipotterService;
import com.witcher.kicker.domain.potterland.service.PotterlandService;
import com.witcher.kicker.domain.rosman.service.RosmanService;
import com.witcher.kicker.domain.rosmean.service.RosmeanService;
import com.witcher.kicker.domain.zigzag.service.ZigzagService;
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
	public CommandLineRunner run(KupipotterService kupipotterService,
								 PotterlandService potterlandService,
								 MailService mailService,
								 ZigzagService zigzagService,
								 RosmeanService rosmeanService,
								 RosmanService rosmanService,
								 CircularPagerService pagerService,
								 KupipotterRequestBuilderService requestFactory) throws Exception {
		return args -> {
//			kupipotterService.sendKupipotterRequest();
//			potterlandService.sendPotterlandRequest();
//			mailService.sendEmail("Test", "hello");
//			pagerService.next();
			System.out.println(requestFactory.buildRequest(pagerService.next()));
		};
	}
}
