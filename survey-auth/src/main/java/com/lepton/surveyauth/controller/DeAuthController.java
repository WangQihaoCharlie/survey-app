package com.lepton.surveyauth.controller;

import com.lepton.surveyauth.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deAuth")
public class DeAuthController {

    private final UserService userService;

    public DeAuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/logout")
    public String logout(@RequestParam String userId, @RequestParam String jwtToken) {
        userService.logout(userId, jwtToken);

        return "logout";
    }
}
