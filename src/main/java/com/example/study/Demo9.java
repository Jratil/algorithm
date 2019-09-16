package com.example.study;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-12 20:29
 * @Description 58 12号笔试第二题
 * <p>
 *     从左到右，一排，每个人一个分数，每个人最低1分。
 *     如果一个孩子旁边的人分数都比他小，则他的必须必比他小的多1
 * </p>
 */
public class Demo9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] num = new int[count];
        for (int i = 0; i < count; i++) {
            num[i] = sc.nextInt();
        }

        int[] source = new int[count];
        for (int i = 0; i < count; i++) {
            if(i == 0) {
                source[i] = 1;
                continue;
            }
            if(num[i] > num[i - 1]) {
                source[i] = source[i - 1] + 1;
            } else {
                source[i] = 1;
            }
        }
        for (int i = count - 2; i >= 0; i--) {
            if(num[i] > num[i + 1] && source[i] <= source[i + 1]) {
                source[i] = source[i + 1] + 1;
            }
        }
        int min = 0;
        for (int i = 0; i < count; i++) {
            min += source[i];
        }
        System.out.println(min);
    }
}
