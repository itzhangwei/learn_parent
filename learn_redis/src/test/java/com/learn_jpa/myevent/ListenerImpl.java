package com.learn_jpa.myevent;

public class ListenerImpl implements PersonListener {
    @Override
    public void RunListener(PersonEvent event) {
        System.out.println("这是监听====奔跑===的动作的!");
    }

    @Override
    public void EatListener(PersonEvent event) {
        System.out.println("这是监听----吃饭---的动作的!");
    }
}
