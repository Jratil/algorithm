package com.example.study;

import java.util.*;

/**
 * @author wen
 * @date 2019-08-27 15:45
 */
public class Demo6 {

    /**
     * 心动网络第一单编程题，按照字典顺序重新排序字符串
     * 给定一些字符串只含有a-z ,我们想对它们重新排序,但是我们重新定义字典序,
     * 这个字典序是由一个a-z的排列给出,输出按新的字典从小到大排序好的字符串列表。
     * 输入描述:
     * 第一行为a-z的排列。
     * 第二行为一个整数N，表示之后有M行(1<=N<=100) ，每行表示一个字符串。
     * 字符串只包含a-z。每个字符串长度满足大于等于1，且小于等于1000。
     * 输出描述:
     * 输出N行，每行为一一个字符串，它们按新的字典定义从小到大排序
     * 输入：
     * cbadefghilkmn
     * fed
     * abc
     * 输出：
     * abc fed
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lstr = sc.nextLine();
        int count = sc.nextInt();
        String[] strs = new String[count];
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            strs[i] = sc.nextLine();
        }

        List<String> list = new ArrayList<>(Arrays.asList(strs));

        // 这里是对每一个输入的字符串也按照字典排序了，
        // 比如上述输入的 fed abc,输出后为cba def
//        for (int i = 0; i < count; i++) {
//            Character[] ch = new Character[strs[i].length()];
//            for (int j = 0; j < ch.length; j++) {
//                ch[j] = strs[i].charAt(j);
//            }
//            Arrays.sort(ch, (o1, o2) -> {
//                int l = 0;
//                int r = 0;
//                for (int j = 0; j < lstr.length(); j++) {
//                    if (o1 == lstr.charAt(j)) {
//                        l = j;
//                    }
//                    if (o2 == lstr.charAt(j)) {
//                        r = j;
//                    }
//                }
//                return l - r;
//            });
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < ch.length; j++) {
//                sb.append(ch[j]);
//            }
//            list.add(sb.toString());
//        }

        // 将list中字符按照首字母重新排序就好了
        list.sort((s1, s2) -> {
            int l = 0;
            int r = 0;
            for (int j = 0; j < lstr.length(); j++) {
                if (s1.charAt(0) == lstr.charAt(j)) {
                    l = j;
                }
                if (s2.charAt(0) == lstr.charAt(j)) {
                    r = j;
                }
            }
            return l - r;
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
