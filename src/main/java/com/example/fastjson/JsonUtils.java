package com.example.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @create 2019-07-26 13:55
 */
public class JsonUtils {

//    public static final String json = JsonStr.JSON3;

    private static List<Object> valueList = new LinkedList<>();

    public static List<Object> findByField(String field, String json) {
        valueList.clear();
        findValue(field, json);
        return valueList;
    }

    private static void findValue(String field, String json) {

        // 把json字符串转换为object
        Object jsonObject = JSON.parse(json);

        // 判断 jsonObject是 JSONArray还是 JSONObject
        if (jsonObject instanceof JSONArray) {
            // 如果是 JSONArray，则遍历里面的值，寻找里面有没有 List或者 Map类型的值
            // 如果是 Map则继续判断
            // 如果是 List则直接将该 List添加到递归继续查找
            for (Object object : (List) jsonObject) {
                if (object instanceof Map) {
                    // 如果该值是 Map类型，则判断这个Map是否有要寻找的字段
                    // 如果有，将其添加到 List中
                    // 如果没有，则将该 Map添加到递归继续查找
                    if (((Map) object).containsKey(field)) {
                        valueList.add(((Map) object).get(field));
                        // } else {
                        // 如果上面的 else没有注释掉，那么如果该含有 field的 Map中还含有该 field
                        // 则不会取出来，而是会直接添加进 List，要不要加上 else和下面的，主要看要求
                        //
                        // 下面，是为了在取出当前 List中含有该字段的 Map后，将该 Map从该 json中删除
                        // 然后把剩余的 json再放进递归中，寻找是否还含有该字段
                        // 也可以直接对 json不做处理放进递归
                        // findValue(field, JSON.toJSONString(object));
                        // 然后再得到结果后去重，这样就会得到不同的值了，具体实现看要求

                        // 获取要去除的json
                        String str = JSON.toJSONString(object);
                        // 得到要去除的 field的值，用来获取 index，然后去除
                        String value = ((Map) object).get(field).toString();
                        // 找到要去除的 field在 json中的下标
                        int start = findPosition(str, field);
                        int end = str.indexOf(value) + value.length() + 2;
                        str = str.substring(start, end);
                        findValue(field, JSON.toJSONString(object).replaceAll(str, ""));
                    }
                    // 2019-7-29 增加
                    // 修复当 List中根的 Map没有 field但是该 Map下子节点含有 field，但是不会把该 Map加入递归的错误
                    findValue(field, JSON.toJSONString(object));
                } else if (object instanceof List) {
                    findValue(field, JSON.toJSONString(object));
                }
            }
        } else if (jsonObject instanceof JSONObject) {
            // 如果是 Map，则先判断该 Map是否是该字段
            if (((Map) jsonObject).containsKey(field)) {
                valueList.add(((Map) jsonObject).get(field));
            }
            // 如果没有，则遍历将 Map里面的 Value取出来
            // 如果取出来的 Value是 List或者 Map，则放到递归继续查找
            for (Map.Entry entry : (Set<Map.Entry>) ((Map) jsonObject).entrySet()) {
                if (entry.getValue() instanceof List || entry.getValue() instanceof Map) {
                    findValue(field, JSON.toJSONString(entry.getValue()));
                }
            }
        }
    }

    private static int findPosition(String json, String field) {
        Stack<Character> stack = new Stack<>();

        for (int i = 1; i < json.length(); i++) {
            if (stack.empty() && field.charAt(0) == json.charAt(i)) {
                int index = i;
                for (int j = 1; j < field.length(); j++) {
                    if (field.charAt(j) == json.charAt(++index)) {
                        if (j == field.length() - 1) {
                            return index - field.length();
                        }
                    } else {
                        break;
                    }
                }
            } else if ('{' == json.charAt(i) || '[' == json.charAt(i)) {
                stack.push('{');
            } else if ('}' == json.charAt(i) || ']' == json.charAt(i)) {
                stack.pop();
            }
        }
        return 1;
    }
}
