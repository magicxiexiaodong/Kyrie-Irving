package com.xxd.serviceImpl;

import com.xxd.service.BaseService;

public class Person implements BaseService{
    @Override
    public void eat() {
        System.out.println("使用筷子吃饭了");
    }

    @Override
    public void wc() {
        System.out.println("测试地球重力是否不存在");
    }
}
