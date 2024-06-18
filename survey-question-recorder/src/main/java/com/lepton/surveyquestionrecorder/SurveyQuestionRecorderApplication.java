package com.lepton.surveyquestionrecorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SurveyQuestionRecorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyQuestionRecorderApplication.class, args);
    }

}
