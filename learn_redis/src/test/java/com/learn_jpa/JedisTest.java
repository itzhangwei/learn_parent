package com.learn_jpa;

import com.learn_jpa.subscribe.TestSubscribe;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;


public class JedisTest {

    private Jedis jedis;
    //创建自定义消息订阅发布类
    private static TestSubscribe subscribe;
    @Before
    public void initJedis(){
        //加载Spring的配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        //获取到交给Spring管理的jedis类
        jedis = (Jedis)context.getBean("jedis");
        //获得自定义消息订阅发布类
        subscribe = (TestSubscribe) context.getBean("testSubscribe");
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
        //jedis在订阅玩频道过后,就会处于等待状态,不会再向下执行任何代码,只有等到取消平道订阅过后才会继续向下执行.
        System.out.println(123);

    }

    /**
     * jedis发布消息
     */
    @Test
    public void TestPublish(){
        //使用jedis发布消息
        jedis.publish("ch1","this is a testMessage");

        //jedis取消订阅频道,由于线程问题,无法保持JedisPubSub中的client一致所以在这里没有办法使用下面方法关闭,采用发送指定消息的同时取消订阅
        //jedis.getClient().unsubscribe();//取消所有订阅,client和jedis功能基本一致,jedis没有取消的方法
        //subscribe.unsubscribe();
        jedis.publish("ch1", "取消所有订阅");

    }

   @After
    public void ColeResource() {
        jedis.close();
    }
}
