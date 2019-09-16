package com.example.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-12 20:47
 * @Description 58 12号笔试第三题
 * <p>
 *     数字矩阵，从左上角走到右下角，求最小的总和
 * </p>
 */
public class Demo10 {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                map[i][k] = sc.nextInt();
            }
        }

        go(map, 0, 0, 0);
        System.out.println(Collections.min(list));
    }

    public static void go(int[][] map, int i, int j, int count) {
        int m = map.length;
        int n = map[0].length;
        if (i == m - 1 && j == n - 1) {
            count += map[m - 1][n - 1];
            list.add(count);
            return;
        }

        count += map[i][j];
        if(i < m - 1) {
            go(map, i + 1, j, count);
        }
        if(j < n - 1) {
            go(map, i, j + 1, count);
        }
    }
}
