package com.example.study;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-23 22:10
 */
public class DeadLock {

    public static void main(String[] args) {

        String a = "1", b = "2";

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("开始执行" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b) {
                        System.out.println("执行了" + Thread.currentThread().getName());
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    System.out.println("开始执行" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a) {
                        System.out.println("执行了" + Thread.currentThread().getName());
                    }
                }
            }
        }).start();

    }
}
