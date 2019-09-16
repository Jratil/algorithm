package com.example.study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-12 20:21
 * @Description 58 12号鄙视第一题
 * <p>
 *     一行数字去重之后的个数
 * </p>
 */
public class Demo8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        String[] strs = in.split(",");
        Set<String> set = new HashSet<>(Arrays.asList(strs));
        System.out.println(set.size());
    }
}
