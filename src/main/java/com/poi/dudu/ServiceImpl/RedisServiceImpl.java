package com.poi.dudu.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

public class RedisServiceImpl {
    @Service
    public class RedisService {
        @Autowired
        RedisTemplate redisTemplate;

    }
}
