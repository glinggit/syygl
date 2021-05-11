package com.syygl.test.study.redisTest;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class RedissonTest {

    @Autowired
    RedissonClient redissonClient;

    public void test() {
        RLock rLock = Redisson.create().getLock("test");

        rLock.lock();


        RLock test = redissonClient.getLock("test");
        test.lock(1000, TimeUnit.MICROSECONDS);



    }
}
