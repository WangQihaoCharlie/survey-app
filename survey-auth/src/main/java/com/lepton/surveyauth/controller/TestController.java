package com.lepton.surveyauth.controller;


import com.lepton.surveyauth.entity.dto.User;
import com.lepton.surveyauth.service.UserService;
import com.lepton.surveyauth.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class TestController {

    private final JwtUtils jwtUtils;

    private final UserService userService;

    public TestController(JwtUtils jwtUtils, UserService userService) {
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        return userService.login(username, password, request.getRemoteAddr());
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.register(user);

        return "1";
    }
}
