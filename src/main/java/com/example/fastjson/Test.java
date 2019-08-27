package com.example.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @create 2019-07-26 15:27
 */
public class Test {
    public static void main(String[] args) {
        String str = "{}";
        Object object = JSON.parse(str);
        if (JSON.parse(str) instanceof JSONArray) {
            System.out.println(object.getClass());
        }
        if (object instanceof JSONObject) {
            System.out.println(object.getClass());
        }
    }
}
