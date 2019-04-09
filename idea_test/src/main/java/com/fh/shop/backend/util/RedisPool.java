package com.fh.shop.backend.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    private static JedisPool jedisPool;

    private static void initPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMinIdle(100);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);

        jedisPool = new JedisPool(jedisPoolConfig,"192.168.1.108",7020);
    }

    static {
        initPool();
    }

    public static Jedis getResource(){
        return jedisPool.getResource();
    }

    private RedisPool(){

    }

    public static void main(String[] args) {
        Jedis jedis = getResource();
        jedis.set("userName","xiaoming");
    }
}
