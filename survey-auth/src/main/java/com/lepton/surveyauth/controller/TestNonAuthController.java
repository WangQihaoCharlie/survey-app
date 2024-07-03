package com.lepton.surveyauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestNonAuthController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
