package com.example.study;

import org.junit.Test;

import java.util.Scanner;

/**
 * 0 1 背包
 * @author wen
 * @date 2019-08-20 10:36
 */
public class Backpack01 {

    @Test
    public void main() {
        // 重量
        int[] w = new int[]{1, 2, 3, 4, 5};
        // 价值
        int[] v = new int[]{2, 6, 3, 8, 4};

        int amount = 10;
        int[][] all = new int[w.length][amount + 1];
        for (int i = 0; i <= amount; i++) {
            all[0][i] = i > w[0] ? v[0] : 0;
        }

        for (int i = 1; i < w.length; i++) {
            for (int j = 0; j <= amount; j++) {
                all[i][j] = all[i - 1][j];
                if (j > w[i]) {
                    all[i][j] = Math.max(all[i][j], v[i] + all[i - 1][j - w[i]]);
                }
            }
        }
        System.out.println(all[w.length - 1][amount]);
    }

    /**
     * 牛客中某道算法
     */
    @Test
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[][] v = new int[n + 1][p + 1];
        for (int i = 0; i <= p; i++) {
            v[0][i] = 100001;
        }

        for (int i = 1; i <= n; i++) {
            for (int j= 1; j <= p; j++) {
                if (arr[i - 1] >= j) {
                    v[i][j] = Math.min(arr[i - 1], v[i - 1][j]);
                } else {
                    v[i][j] = Math.min(v[i - 1][j], arr[i - 1] + v[i - 1][j - arr[i - 1]]);
                }
            }
        }
        System.out.println(v[n][p]);
    }
}
