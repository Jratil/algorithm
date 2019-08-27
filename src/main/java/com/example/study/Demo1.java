package com.example.study;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wen
 * @date 2019-08-16 16:33
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inS = sc.nextLine();
        String[] ss = inS.split(",");
        int[] in = new int[ss.length];
        int[] nums = new int[in.length];
        for (int i = 0; i < ss.length; i++) {
            in[i] = Integer.parseInt(ss[i]);
            nums[i] = 1;
        }

        for (int i = 1; i < in.length; i++) {
            if (in[i] > in[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            }
        }

        for (int i = in.length - 2; i >= 0; i--) {
            if (in[i] > in[i + 1] && nums[i] == nums[i + 1]) {
                nums[i] += 1;
            } else if (in[i] > in[i + 1] && nums[i] < nums[i + 1]) {
                nums[i] = nums[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
    }
}
