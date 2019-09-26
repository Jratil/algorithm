package com.example.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-16 19:14
 * @Description 搜狗第一道算法题，防火墙过滤ip
 */
/*
5 3
// 过滤规则
222.205.58.16
*.58.16
222.205.58.*
*.16
224.*
// 要过滤的ip
222.205.58.17
222.205.59.19
223.205.59.16
 */
public class Demo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ruleCount = sc.nextInt();
        int ipCount = sc.nextInt();
        sc.nextLine();
        String[] rules = new String[ruleCount];
        for (int i = 0; i < ruleCount; i++) {
            rules[i] = sc.nextLine();
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ipCount; i++) {
            String ip = sc.nextLine();

            String result = "0 ";
            for (int j = 0; j < ruleCount; j++) {
                String rule = rules[j];

                if(rule.startsWith("*")) {
                    rule = rule.substring(1);
                    if (ip.endsWith(rule)) {
                        result = "1 ";
                        break;
                    }
                } else if(rule.endsWith("*")) {
                    rule = rule.substring(0, rule.length() - 1);
                    if (ip.startsWith(rule)) {
                        result = "1 ";
                    }
                } else if (rule.equals(ip)) {
                    result = "1 ";
                }

                /*if (rule.startsWith("*") || rule.endsWith("*")) {
                    int pointCount = rule.split("\\.").length - 1;
                    if (rule.startsWith("*")){
                        String[] ips = ip.split("\\.");
                        int index = 0;
                        for (int k = 0; k < 4 - pointCount; k++) {
                            index += ips[k].length();
                        }
                        if (ip.substring(index + 4 - pointCount).equals(rule.substring(rule.indexOf(".") + 1))) {
                            result = "1 ";
                            break;
                        }
                    } else if (rule.endsWith("*")) {
                        String[] ips = ip.split("\\.");
                        int lastIndex = 0;
                        for (int k = 0; k < pointCount; k++) {
                            lastIndex += ips[k].length();
                        }

                        if (ip.substring(0, lastIndex + pointCount - 1).equals(rule.substring(0, rule.lastIndexOf(".")))) {
                            result = "1 ";
                            break;
                        }
                    }
                } else if (rule.equals(ip)) {
                    result = "1 ";
                    break;
                }*/
            }
            s.append(result);
        }
        System.out.println(s.toString().substring(0, s.lastIndexOf(" ")));
    }
}
