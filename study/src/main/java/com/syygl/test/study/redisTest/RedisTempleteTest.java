package com.syygl.test.study.redisTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;

public class RedisTempleteTest {


    @Autowired
    private RedisTemplate redisTemplate;

    public void redisTest(){

        ValueOperations valueOperations = redisTemplate.opsForValue();

        HashOperations hashOperations = redisTemplate.opsForHash();

        SetOperations setOperations = redisTemplate.opsForSet();

        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

        ListOperations listOperations = redisTemplate.opsForList();


    }



}
