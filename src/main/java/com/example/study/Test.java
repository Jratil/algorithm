package com.example.study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @date 2019-08-05 14:23
 */
public class Test {


    @org.junit.Test
    public void test() {
        int[] a = new int[]{1,2,3,4,5,6,7};
        reOrderArray(a);
        System.out.println(Arrays.toString(a));
    }

    public void reOrderArray(int [] array) {
        int[] a = new int[array.length];
        int j = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 1) {
                a[j] = array[i];
                j++;
            }
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                a[j] = array[i];
                j++;
            }
        }
        ExecutorService executors = Executors.newCachedThreadPool();
        Future<?> submit = executors.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        });
        System.out.println(Arrays.toString(a));
        array = Arrays.copyOf(a, a.length);
        Map<String, String> map = new LinkedHashMap<>();
    }
}
