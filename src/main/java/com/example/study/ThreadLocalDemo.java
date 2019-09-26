package com.example.study;

import java.util.*;

/**
 * @author wen
 * @version 1.0.0
 * @date 2019-09-24 14:42
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal t = new ThreadLocal();
        Map<String, String> map = new HashMap<>();
        List<HashMap<String, String>> list = new LinkedList<>();

        while (true) {
            list.add(new HashMap<String, String>(10000, 0.00001f) {{
                put("a", "a");
                put("b", "b");
                put("c", "a");
                put("d", "b");
            }});
        }
    }
}
