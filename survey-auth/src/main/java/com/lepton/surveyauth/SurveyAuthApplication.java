package com.lepton.surveyauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SurveyAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyAuthApplication.class, args);
    }

}
