package com.rhuan.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rhuan.cursomc.services.DBService;
import com.rhuan.cursomc.services.EmailService;
import com.rhuan.cursomc.services.MockEmailService;
import com.rhuan.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		if (!"create".equals(strategy)) {
			return false;
		}

		dbService.instatiateTestDatabase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		//return new SmtpEmailService();
		return new MockEmailService();
	}

}
