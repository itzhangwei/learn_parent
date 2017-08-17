package com.learn.myevent;

/**
 * 事件源,事件源里面包含事件的监听对象,在事件源的指定要监听的方法发生改变的时候去调用事件监听器里面的方法.
 */
public class Person {
    //事件监听器对象
    private PersonListener listener;

    //在事件触发的时候调用监听器的方法
    public void eat() {
        if (listener != null) {
            //创建当前事件对象
            PersonEvent event = new PersonEvent(this);
            //调用监听器里面监听吃饭动作的方法
            listener.EatListener(event);
        }
        System.out.println("吃饭!");
    }

    public void run() {
        if (listener != null) {
            //创建当前事件对象
            PersonEvent event = new PersonEvent(this);
            //调用监听器里面监听吃饭动作的方法
            listener.RunListener(event);
        }
        System.out.println("奔跑!");
    }

    //给事件源添加监听器
    public void registListener(PersonListener listener) {
        this.listener = listener;

    }
}
