package com.example.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-16 16:22
 * @Description
 */
public class PeopleHandler implements InvocationHandler {

    private People target;

    public PeopleHandler(People target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始说话！");
        Object obj = method.invoke(target, args);
        System.out.println("说完了");
        return obj;
    }
}
