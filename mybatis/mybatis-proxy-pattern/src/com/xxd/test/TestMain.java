package com.xxd.test;

import com.xxd.service.BaseService;
import com.xxd.serviceImpl.Person;
import com.xxd.util.ProxyFactory;

public class TestMain {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // mike.eat()
        BaseService mike = ProxyFactory.builder(Person.class);
        mike.eat();
    }
}
