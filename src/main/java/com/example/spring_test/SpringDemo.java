package com.example.spring_test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @date 2019-08-09 13:46
 */
public class SpringDemo {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Car car = (Car) context.getBean("car");
        System.out.println(car.getHeight());
    }
}
