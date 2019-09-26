package com.example.algorithm;


import java.util.*;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-20 21:03
 *
 * 度小满笔试第二题
 */
public class Demo14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] nums = new int[t];
        for (int i = 0; i < t; i++) {
            nums[i] = sc.nextInt();
        }

        List<String> allList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int length = nums[i] - 1;
            int rLength = 0;
            while (length != 0) {
                rLength += length;
                length--;
            }
            List<Integer> list = new ArrayList<>();
            for (int k = 1; k < nums[i]; k++) {
                for (int r = k + 1; r <= nums[i]; r++) {
                    int m = k;
                    int n = r;
                    int temp = m % n;
                    while (temp != 0) {
                        m = n;
                        n = temp;
                        temp = m % n;
                    }
                    if(Math.abs(n) == 1) {
                        list.add(k * r);
                    }
                }
            }
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(j);
            }
            if(sum % rLength == 0) {
                allList.add(String.valueOf(sum / rLength));
            } else {
                allList.add(sum + "/" + rLength);
            }
        }
        for (int i = 0; i < allList.size(); i++) {
            System.out.println(allList.get(i));
        }
    }
}
