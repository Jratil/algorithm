package com.example.algorithm;

import java.util.Scanner;

/**
 * @author wen
 * @date 2019-08-19 14:53
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 菜品数量
        int x = sc.nextInt(); // 优惠券价格
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }// 菜品单价

        int[][] v = new int[n + 1][x + 1];
        // 当菜品数量=0，优惠券价格=10001 ？？？只要大于10000即可
        for (int i = 0; i <= x; i++) {
            v[0][i] = 10001;
        }
        // 优惠券价格为0的情况,可不设置，默认为0
        //for(int i= 0; i<n ;i++){v[i][0] = 0;}

        // 循环求解，求放入背包的最小值
        for (int i = 1; i <= n; i++) { // 从第一个物品开始
            for (int j = 1; j <= x; j++) { // 从背包容量=1 开始
                if (arr[i - 1] >= j) { // 当前物品价格 > 背包容量
                    v[i][j] = Math.min(arr[i - 1], v[i - 1][j]); // 选之前和当前价格最小的
                    //v[i][j] = v[i-1][j]; // 选之前和当前价格最小的
                } else { // 当前物品价格 < 背包容量
                    // 选 min（之前的策略，把当前物品装入后剩余背包能装最少的物品） 两者最小值
                    v[i][j] = Math.min(v[i - 1][j], arr[i - 1] + v[i - 1][j - arr[i - 1]]);
                }
            }
        }

        //for(int[] arr1: v){System.out.println(Arrays.toString(arr1));}
        System.out.println(v[n][x]);
    }
}
