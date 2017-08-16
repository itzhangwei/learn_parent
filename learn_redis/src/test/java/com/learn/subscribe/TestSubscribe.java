package com.learn.subscribe;


import redis.clients.jedis.JedisPubSub;

/**
 * 当一次订阅多个频道的时候,会每次调用下初始化订阅频道的方法.
 */
public class TestSubscribe extends JedisPubSub {


    /**
     * 取得消息订阅后处理的方法
     * @param channel 频道名称
     * @param message 发布的消息
     */
    @Override
    public void onMessage(String channel, String message) {
        //如果发送指定的消息,取消所有订阅
        if (message.equals("取消所有订阅")) {
            this.unsubscribe();
            return;
        }
        System.out.println(channel+"=========="+message);
    }

    /**
     * 取得按表达式取得消息后方法
     * @param pattern
     * @param channel
     * @param message
     */
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        super.onPMessage(pattern, channel, message);
    }

    /**
     * 按表达式的方式获取订阅时候的处理方法
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        super.onPSubscribe(pattern, subscribedChannels);
    }


    /**
     * 取消按表达式的方式订阅的后的处理方法
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        super.onPUnsubscribe(pattern, subscribedChannels);
    }

    /**
     * 初始化订阅方法后执行的方法
     * @param channel 频道名称
     * @param subscribedChannels 频道的排序吧,从一开始
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("初始化订阅频道,频道名称:"+channel+",频道几:"+subscribedChannels);
    }

    /**
     * 取消订阅的时候的处理方法
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("取消消息订阅:"+channel+"  "+subscribedChannels);
    }


}
