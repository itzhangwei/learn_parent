package com.learn.queue;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 测试redis的队列功能
 */
public class TestQueue {

    private Jedis jedis = new Jedis("localhost");

    @Test
    public void queueTest() {
        //同时向redis的队列中添加多个值
        jedis.lpush("list1", "this is a fist value in this list", "2");
        System.out.println(jedis.llen("list1"));
        String value = jedis.rpop("list1");
        System.out.println(value);
        jedis.close();
    }
}
