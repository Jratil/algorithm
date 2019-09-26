package com.example.algorithm;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-20 17:46
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Demo13 {

    @Test
    public void test() {
        int[] array = new int[] {1,2,4,7,11,15};
        int sum = 15;
        int l = 0;
        int r = array.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (l < r) {
            if (array[l] + array[r] > sum) {
                r--;
            } else if (array[l] + array[r] < sum) {
                l++;
            } else {
                list.add(array[l]);
                list.add(array[r]);
                l++;
                r--;
            }
        }
        if(list.size() == 0) {
            System.out.println(list);
            return;
        }
        int result = Integer.MAX_VALUE;
        int[] a = new int[2];
        for (int i = 0; i < list.size(); i = i + 2) {
            int re = list.get(i) * list.get(i + 1);
            if (re < result) {
                result = re;
                a[0] = list.get(i);
                a[1] = list.get(i + 1);
            }
        }
        System.out.println(new ArrayList<Integer>() {{
            add(a[0]);
            add(a[1]);
        }});
    }

}
