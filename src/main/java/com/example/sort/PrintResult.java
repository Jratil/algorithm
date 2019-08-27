package com.example.sort;

import java.util.Arrays;

/**
 * @create 2019-07-24 14:30
 */
public abstract class PrintResult {

    public abstract void sort(int[] a);

    public void print() {
        int[][] a = ArrayStatic.A;
        for (int i = 0; i < a.length; i++) {
            sort(a[i]);
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
