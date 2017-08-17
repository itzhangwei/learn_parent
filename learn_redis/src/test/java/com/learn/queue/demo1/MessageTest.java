package com.learn.queue.demo1;

import redis.clients.jedis.Jedis;

import java.io.IOException;

public class MessageTest {
    public static byte[] queueName = "testQueue".getBytes();

    public static Jedis jedis = new Jedis("localhost");
    ;

    static {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //项redis中初始化数据
    private static void init() throws IOException {
        for (int i = 0; i < 10000; i++) {
            Message message = new Message(i, "这是第: " + i + " 条消息!");
            jedis.lpush(queueName, ObjectUtils.objectToByteArr(message));
            jedis.expire(queueName, 3600);
        }
    }

    public static Message popMessage() throws Exception {
        byte[] bytes = jedis.rpop(queueName);
        Message message = (Message) ObjectUtils.bytesToObject(bytes);
        if (message != null) {
            System.out.println(message.getId() + "---" + message.getContent());
        }
        return message;
    }

    public static void main(String[] args) throws Exception {
        popMessage();
    }
}
