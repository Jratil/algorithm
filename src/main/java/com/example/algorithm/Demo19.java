package com.example.algorithm;

import org.junit.Test;

/**
 * @author jun
 * @version 1.0.0
 * @date 2019-09-29 13:55
 */
public class Demo19 {

    @Test
    public void test() {
        System.out.println(cutRope(2));
    }

    public int cutRope(int target) {
        for (int i = 1; i < target; i++) {
            solution(target - i, i);
        }
        return max;
    }

    private int max = 0;

    private void solution(int n, int sum) {
        if (n <= 1) {
            max = max > sum ? max : sum;
            return;
        }

        for (int i = 1; i <= n; i++) {
            solution(n - i, sum * i);
        }
    }
}
