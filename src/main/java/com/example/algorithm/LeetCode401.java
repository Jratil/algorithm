package com.example.algorithm;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jun
 * @version 1.0.0
 * @date 2019-09-27 10:41
 * 力扣 401题，二进制手表
 */
public class LeetCode401 {

    @Test
    public void test() {
        System.out.println(readBinaryWatch(2));
    }

    List<String> list = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        int[] hour = new int[]{8, 4, 2, 1};
        int[] min = new int[]{32, 16, 8, 4, 2, 1};

        for (int i = 0; i < 6; i++) {
            helper(hour, min, 0, 0, i, num);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    private void helper(int[] hour, int[] min, int hs, int ms, int p, int n) {
        // 把所有可能取出来，放入set，再去除不符合的
        if (n <= 0) {
            if(hs < 12 && ms < 60) {
                String mSum = ms >= 10 ? String.valueOf(ms) : "0" + ms;
                list.add(hs + ":" + mSum);
            }
            return;
        }
        int i = p;
        for (; i < hour.length; i++) {
            helper(hour, min, hour[i] + hs, ms, i + 1, n - 1);
        }
        for (i = i - hour.length; i < min.length; i++) {
            helper(hour, min, hs, min[i] + ms, i + hour.length + 1, n - 1);
        }
    }
}
