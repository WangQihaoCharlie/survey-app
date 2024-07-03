package com.lepton.surveyauth.service;


import com.lepton.surveyauth.entity.dto.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String login(String username, String password);

    void logout();

    String register(User user);

    User findUserByUsername(String username);
}
