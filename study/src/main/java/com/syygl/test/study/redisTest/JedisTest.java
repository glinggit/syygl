package com.syygl.test.study.redisTest;

import redis.clients.jedis.Jedis;

public class JedisTest {

    //Jedis对象不是线程安全的，在多线程下使用同一个Jedis对象会出现并发问题，
    // 为了避免每次使用Jedis对象时都需要重新创建，
    // Jedis提供了JedisPool。Jedis是线程安全的连接池


    public void test(){
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("singleJedis", "hello jedis!");
        System.out.println(jedis.get("singleJedis"));

        jedis.expire("123", 12);//设置key的过期时间
        jedis.setnx("lock", "123");//redis锁的应用







        jedis.close();













    }
}
