package com.lepton.surveyauth.service.impl;


import com.lepton.surveyauth.dao.UserDao;
import com.lepton.surveyauth.entity.dto.User;
import com.lepton.surveyauth.service.UserService;
import com.lepton.surveyauth.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final JwtUtils jwtUtils;

    private final RedisTokenService redisTokenService;

    @Autowired
    public UserServiceImpl(UserDao userDao, JwtUtils jwtUtils, RedisTokenService redisTokenService) {
        this.userDao = userDao;
        this.jwtUtils = jwtUtils;
        this.redisTokenService = redisTokenService;
    }


    @Override
    public String login(String username, String password, String ip) {
        User user = userDao.getByUsername(username);
        if(user == null) {
            return "Invalid username or password";
        }
        else if(user.getPassword().equals(password)) {
            String token = jwtUtils.generateToken(username);
            String current = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
            redisTokenService.addUserTokenToHash(String.valueOf(user.getId()), username, current, ip);

            return token;
        }
        return "Invalid username or password";
    }

    @Override
    public void logout(String username, String token) {
        User user = userDao.getByUsername(username);
        redisTokenService.addToSet("usertoken:" + user.getId(), token);
    }

    @Override
    public void register(User user) {
        userDao.insert(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.getByUsername(username);
    }
}

