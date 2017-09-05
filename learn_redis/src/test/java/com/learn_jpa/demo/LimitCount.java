package com.learn_jpa.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * 使用redis模拟一个一分钟之类限制访问次数的demo.
 */
public class LimitCount {
    //创建实例对象
    private Jedis jedis = new Jedis("localhost");

    @Test
    public void Test() {
        //模拟用户频繁请求
        for (int i = 0; i < 20; i++) {
            //判断是否可以登录
            boolean falg = login("192.168.242.1");
            if (falg) {
                System.out.println("正常访问!");
            } else {
                System.out.println("访问受限!");
            }
        }
    }

    /**
     * 判断在一分钟以内,访问次数是否超过指定次数,没超过返回true标记,超过返回false标记
     *
     * @param ip
     * @return
     */
    private boolean login(String ip) {
        String value = jedis.get("loginCount");

        //处理第一次登录
        if (value == null) {
            value = "1";
            jedis.set("loginCount", value);
            //设置存活时间
            jedis.expire("loginCount", 60);
        }
        Integer count = Integer.parseInt(value);
        //判断登录次数
        if (count <= 10) {
            //自增
            jedis.incr("loginCount");
            return true;
        }
        return false;
    }

    /**
     * 检测变量在事物执行期间是否被别的客户端更改过值,如果期间改变了值,事物就不会执行,否这执行事物
     */
    @Test
    public void Testwatch() throws InterruptedException {
        jedis.set("a", "1");
        //设置存活周期
        jedis.expire("a", 3600);
        //查看剩余存活周期
        Long ttl = jedis.ttl("a");
        System.out.println("剩余存活时间:" + ttl);
        //监视a变量
        jedis.watch("a");
        //取消监测
        //jedis.unwatch();
        //开启事物
        Transaction transaction = jedis.multi();
        transaction.set("a", "1");
        //时线程休眠
        Thread.sleep(20000);
        //提交事物
        List<Object> list = transaction.exec();
        if (list == null) {
            System.out.println("事物没有执行!");
        } else {
            list.forEach(o -> System.out.println(o.toString()));
            System.out.println("事物执行了!");
        }

    }
}
