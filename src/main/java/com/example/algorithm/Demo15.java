package com.example.algorithm;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-21 19:38
 */
public class Demo15 {

    @Test
    public void test() {
        String str = ".12345e+6";
        System.out.println("输入：" + str);
        System.out.println(main(str.toCharArray()));
    }

    public boolean main(char[] str) {

        if (str == null) {
            return false;
        }
        boolean e = false;
        boolean p = false;

        for (int i = 0; i < str.length; i++) {
            // 如果是出现+-，则一定要在第一位或者e的后面，否则就返回false
            if (str[i] == '+' || str[i] == '-') {
                if (i != str.length - 1
                        && (i == 0 || str[i - 1] == 'e' || str[i - 1] == 'E')
                        && (str[i + 1] > '0' && str[i + 1] < '9')) {
                    continue;
                } else {
                    return false;
                }
            }

            // 如果是e，判断是否已经出现过e或者是否已经到达结尾
            if (str[i] == 'e' || str[i] == 'E') {
                if (e || i == str.length - 1) {
                    return false;
                }
                e = true;
                continue;
            }
            if (str[i] == '.') {
                if (e || p || i == str.length - 1 || str[i + 1] > '9' || str[i + 1] < '0') {
                    return false;
                }
                p = true;
                continue;
            }
            if (str[i] > '9' || str[i] < '0') {
                return false;
            }
        }
        return true;
    }
}
