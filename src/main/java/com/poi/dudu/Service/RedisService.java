package com.poi.dudu.Service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RedisService {
    @Autowired
    RedisTemplate redisTemplate;

}
