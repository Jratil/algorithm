package com.example.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jun
 * @version 1.0.0
 * @date 2019-09-27 14:26
 * 字母大小写全排序
 */
public class LeetCode784 {

    @Test
    public void test() {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public List<String> letterCasePermutation(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    List<String> list = new ArrayList<>();

    private void helper(String s, int p) {
        if (p == s.length()) {
            list.add(s);
            return;
        }
        helper(s, p + 1);

        if ((s.charAt(p) >= 'a' && s.charAt(p) <= 'z') ||
                (s.charAt(p) >= 'A' && s.charAt(p) <= 'Z')) {
            if (s.charAt(p) >= 'a' && s.charAt(p) <= 'z') {
                s = s.substring(0, p) + s.substring(p, p + 1).toUpperCase() + s.substring(p + 1);
            } else if (s.charAt(p) >= 'A' && s.charAt(p) <= 'Z') {
                s = s.substring(0, p) + s.substring(p, p + 1).toLowerCase() + s.substring(p + 1);
            }
            helper(s, p + 1);
        }
    }
}
