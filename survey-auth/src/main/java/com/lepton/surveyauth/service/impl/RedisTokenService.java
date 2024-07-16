package com.lepton.surveyauth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

@Service
public class RedisTokenService {


    @Autowired
    public RedisTokenService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private final RedisTemplate<String, String> redisTemplate;


    public void addToSet(String userId, String token) {
        BoundSetOperations<String, String> setOps = redisTemplate.boundSetOps(userId);
        setOps.add(token);
    }


    public void addUserTokenToHash(String userId, String username, String lastLogin, String ip) {

        HashMap<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("username", username);
        map.put("lastLogin", lastLogin);
        map.put("ip", ip);

        redisTemplate.opsForHash().putAll("user:" + userId, map);
        redisTemplate.expire("user:" + userId, Duration.ofDays(10));
    }

    public Set<String> getUserTokens(String userToken) {
        return redisTemplate.opsForSet().members(userToken);
    }

    public Set<String> rangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    public Long remove(String key, String... members) {
        return redisTemplate.opsForZSet().remove(key, (Object) members);
    }

}
