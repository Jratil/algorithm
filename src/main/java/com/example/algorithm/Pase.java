package com.example.algorithm;

    import java.util.Scanner;

/**
 * @date 2019-08-10 15:04
 */
public class Pase {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int num = n;
        String result = "";
        while (num >= n && num <= m) {
            if (Math.pow(num / 100, 3) +
                    Math.pow(num % 100 / 10, 3) +
                    Math.pow(num % 10, 3) == num) {
                result = result + num + " ";
            }
            num++;
        }
        if("".equals(result) || result == null) result = "no";
        System.out.println(result.toString());
    }
}
