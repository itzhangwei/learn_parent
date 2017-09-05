package com.learn_jpa.myevent;

import org.junit.Test;

public class TestMyEvent {
    @Test
    public void function() {
        //创建时间源对象
        Person p = new Person();
        //创建监听器对象
        PersonListener listener = new ListenerImpl();
        //给事件源对象注册监听器
        p.registListener(listener);
        //调用时间源对象中的方法,然后监听器中方法会实现
        p.eat();
        p.run();
    }
}
