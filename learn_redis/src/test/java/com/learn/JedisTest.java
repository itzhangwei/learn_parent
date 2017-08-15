package com.learn;

import com.learn.subscribe.TestSubscribe;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;


public class JedisTest {

    private Jedis jedis;
    //创建自定义消息订阅发布类
    private  TestSubscribe subscribe = new TestSubscribe();
    @Before
    public void initJedis(){
        //加载Spring的配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        //获取到交给Spring管理的jedis类
        jedis = (Jedis)context.getBean("jedis");
    }
    @Test
    public void TestApplicationXml(){

        //设置值,取值
        jedis.set("name","zhangsan");
        String name = jedis.get("name");
        System.out.println(name);
        //关闭资源
        jedis.close();

    }

    @Test
    /**
     * 测试redis订阅消息
     */
    public void TestSubscribe(){

        //订阅频道,可以订阅多个频道,channel频道
        //jedis.subscribe(subscribe,"ch1","ch2");
        jedis.subscribe(subscribe,new String[]{"ch1","ch2"});//使用数组订阅多个频道
        //jedis在订阅玩频道过后,就会处于等待状态,不会再向下执行任何代码
        System.out.println(123);
        /*//使用jedis发布消息
        new Jedis("127.0.0.1",6379).publish("ch1", "this is  a message");
        //关闭资源
        jedis.close();*/
    }

    /**
     * jedis发布消息
     */
    @Test
    public void TestPublish(){
        //使用jedis发布消息
        jedis.publish("ch1","this is a testMessage");
        //jedis取消订阅频道,只能通过jedisPuBSub类来取消.

        jedis.getClient().unsubscribe();//取消所有订阅,client和jedis功能基本一致,jedis没有取消的方法
        //subscribe.unsubscribe();取消订阅底层也就是调用的client里面的这个方法
    }

   // @After
    public void ColeResource() {
        jedis.close();
    }
}
