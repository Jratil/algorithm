package com.example.study.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-16 16:21
 * @Description
 */
public class PeopleImpl implements People {

    @Override
    public String say(String str) {
        return str;
    }

    @Test
    public void test() {
        People people = new PeopleImpl();
        PeopleHandler handler = new PeopleHandler(people);
        People target = (People) Proxy.newProxyInstance(handler.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        System.out.println(target.say("Hello"));
    }
}
