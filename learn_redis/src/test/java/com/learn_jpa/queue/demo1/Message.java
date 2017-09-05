package com.learn_jpa.queue.demo1;

import java.io.Serializable;

/**
 * 消息类,用来保存消息的对象
 */
public class Message implements Serializable {
    private int id;

    private String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
