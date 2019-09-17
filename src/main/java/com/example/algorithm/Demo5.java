package com.example.algorithm;

import org.junit.Test;

/**
 * @author wen
 * @date 2019-08-27 15:39
 */
public class Demo5 {

    // 从有序数组找数字出现的个数
    @Test
    public void main() {
        int[] a = new int[]{1, 3, 5, 6, 6, 6, 7, 9};
        int num = 6;
        int mid = a.length / 2;
        int start = 0;
        int end = 0;
        if(num < mid) {
            start = left(a, 0, mid - 1);
        } else {
            end = right(a, mid, a.length - 1);
        }
        System.out.println(end - start);
    }

    private int left(int[] a, int start, int end) {

        return 0;
    }

    private int right(int[] a, int start, int end) {
        return 0;
    }
}
