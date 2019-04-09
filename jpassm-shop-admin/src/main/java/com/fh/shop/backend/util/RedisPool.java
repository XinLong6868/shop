package com.fh.shop.backend.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
    //私有的静态的全局变量
    private static JedisPool jedisPool;
    //私有的构造方法
    private RedisPool (){}
    //设置单例连接池private
     static void initRedis(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(1000);
        poolConfig.setMaxIdle(10);
        poolConfig.setMinIdle(10);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        //虚拟机IP：192.168.1.115；端口号：6379
        jedisPool = new JedisPool(poolConfig,"192.168.1.115",7001);
    }

    static {
        initRedis();
    }

    /**
     * 公有的静态方法 通过该方法访问linux中的redis缓存
     * @return
     */
    public static Jedis getResource(){
        return jedisPool.getResource();
    }

    public static void main(String[] args) {
        getResource().set("hehe","haha");
        System.out.println(getResource().get("hehe"));
    }


}
