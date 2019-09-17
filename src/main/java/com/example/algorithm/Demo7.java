package com.example.algorithm;

import java.io.IOException;
import java.util.*;

/**
 * @author wen
 * @date 2019-09-02 18:08
 * <p>
 *     奇安信第一道算法
 * </p>
 */
public class Demo7 {

    public static void main(String[] args) throws IOException {
        // 这里是输入的参数
        Scanner sc = new Scanner(System.in);
        int endPid = -1;
        String[] str = sc.nextLine().split(" ");
        int[] pid = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            pid[i] = (Integer.parseInt(str[i]));
        }
        str = sc.nextLine().split(" ");
        int[] ppid = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            ppid[i] = (Integer.parseInt(str[i]));
        }
        endPid = sc.nextInt();
        // 输入完毕

        int amount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pid.length; i++) {
            map.put(pid[i], ppid[i]);
        }
        for (Map.Entry entry : map.entrySet()) {
            if(((Integer) entry.getKey()) == endPid) {
                amount++;
            }
        }
        try {
            throw new OutOfMemoryError();
        } catch (Error e) {
            e.printStackTrace();
        }
        map.remove(endPid);
        for (Map.Entry entry : map.entrySet()) {
            if(((Integer) entry.getValue()) == endPid) {
                amount = amount + 2;
            }
        }
        System.out.println(amount);
    }
}
