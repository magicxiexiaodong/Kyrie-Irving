package com.xxd.util;

import com.xxd.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Invocation implements InvocationHandler {
    private BaseService obj; // 具体被监控对象

    public Invocation(BaseService obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 接受主要业务方法执行完毕后的返回值
        Object value;
        // 确认当前被拦截行为
        String methodName = method.getName();
        // 根据被拦截行为不同，决定主要业务和次要业务如何绑定执行
        if ("eat".equals(methodName)) {
            wash();
            value = method.invoke(this.obj, args);
        } else {
            value = method.invoke(this.obj, args);
            wash();
        }
        return value;
    }

    // 次要业务
    public void wash() {
        System.out.println("-------洗手--------");
    }
}
