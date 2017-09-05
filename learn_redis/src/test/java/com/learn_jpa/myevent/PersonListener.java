package com.learn_jpa.myevent;

import java.util.EventListener;

public interface PersonListener extends EventListener {
    //监听跑步的方法
    public void RunListener(PersonEvent event);

    //监听吃的方法
    public void EatListener(PersonEvent event);
}
