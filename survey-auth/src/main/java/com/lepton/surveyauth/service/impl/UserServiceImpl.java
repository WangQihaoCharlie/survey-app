package com.lepton.surveyauth.service.impl;


import com.lepton.surveyauth.dao.UserDao;
import com.lepton.surveyauth.entity.dto.User;
import com.lepton.surveyauth.service.UserService;
import com.lepton.surveyauth.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final JwtUtils jwtUtils;

    public UserServiceImpl(UserDao userDao, JwtUtils jwtUtils) {
        this.userDao = userDao;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public String login(String username, String password) {
        User user = userDao.getByUsername(username);
        if(user == null) {
            return "Invalid username or password";
        }
        else if(user.getPassword().equals(password)) {
            return jwtUtils.generateToken(username);
        }
        return "Invalid username or password";
    }

    @Override
    public void logout() {

    }

    @Override
    public String register(User user) {
        userDao.insert(user);
        return "";
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.getByUsername(username);
    }
}
