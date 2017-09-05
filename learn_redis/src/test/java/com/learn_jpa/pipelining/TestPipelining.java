package com.learn_jpa.pipelining;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * redis中管道引用test
 */
public class TestPipelining {

    private Jedis jedis = new Jedis("localhost");

    /**
     * 在管道发送异步命令,不需要等待同步返回的数据.效率高
     */
    @Test
    public void test1() {
        //获取管道
        Pipeline pipelined = jedis.pipelined();
        //获取当前系统时间
        long start = System.currentTimeMillis();
        //使用管道插入数据
        for (int i = 0; i < 10000; i++) {
            pipelined.set(i + "", "" + i);
            pipelined.expire(i + "", 60);
        }
        //获取所有异步返回结果
        List<Object> result = pipelined.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("用时:" + (end - start));
        //断开连接
        jedis.disconnect();
        System.out.println(result.size());
        result.forEach(o -> System.out.println(o.toString()));
    }

    /**
     * 在redis管道调用中使用事物
     */
    @Test
    public void test2() {
        Pipeline pipelined = jedis.pipelined();
        long start = System.currentTimeMillis();
        //开启管道事物
        pipelined.multi();
        for (int i = 0; i < 10000; i++) {
            pipelined.set(i + "", "" + i);
            pipelined.expire(i + "", 60);

        }
        //提交事物
        pipelined.exec();
        List<Object> result = pipelined.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
