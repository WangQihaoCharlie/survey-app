package com.lepton.surveyauth.service;


import com.lepton.surveyauth.entity.dto.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String login(String username, String password, String ip);

    void logout(String username, String token);

    void register(User user);

    User findUserByUsername(String username);
}
