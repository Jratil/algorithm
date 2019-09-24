package com.example.study.proxy;

/**
 * @author wenjj2@meicloud.com
 * @version 1.0.0
 * @date 2019-09-16 16:21
 * @Description
 */
public interface People {

    default void a() {
        System.out.println("a");
    }

    String say(String str);
}
