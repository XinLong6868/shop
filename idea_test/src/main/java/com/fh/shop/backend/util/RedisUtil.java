package com.fh.shop.backend.util;


import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static String get(String key){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getResource();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != jedis){
                jedis.close();
                jedis = null;
            }
        }

        return result;
    }

    public static void del(String key){
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResource();
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != jedis) {
                jedis.close();
                jedis = null;
            }
        }
    }

    public static void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != jedis) {
                jedis.close();
                jedis = null;
            }
        }

    }

    public static void main(String[] args) {

        RedisUtil.set("bookName", "三国");

        System.out.println(RedisUtil.get("bookName"));
    }
}
