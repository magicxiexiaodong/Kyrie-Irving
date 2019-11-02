package com.xxd.util;

import com.xxd.dao.SqlSession;

import java.lang.reflect.Proxy;

public class SqlSessionFactory {

    public static SqlSession build(Class classfile) throws IllegalAccessException, InstantiationException {
        // 被监控的实例对象
        SqlSession obj = (SqlSession) classfile.newInstance();

        // 创建一个通知对象
        Invocation adviser = new Invocation(obj);

        // 向JVM申请负责监控obj对象指定行为的监控对象(代理对象)
        /**
         * loader 被监控对象的类文件在内存中的真实地址
         * interfaces 被监控对象的类文件实现接口
         * h:监控对象发现类对象要执行被监控行为，应该由哪个通知对象进行辅助 ==> 通知对象
         */
        SqlSession $proxy = (SqlSession) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), adviser);
        return $proxy;
    }
}
