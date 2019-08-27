package com.example.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @create 2019-07-24 14:46
 */
@Log4j
public class FastJsonStudy {

    private static String json = JsonStr.JSON1;

    public static void main(String[] args) {
//        FastJsonStudy fastJsonStudy = new FastJsonStudy();
//        fastJsonStudy.json2Map();

        long before = System.currentTimeMillis();
//        System.out.println(JsonUtils.findByField("currency_id", json));
        System.out.println(JsonUtils.findByField("site", json));
        System.out.println("花费时间" + (System.currentTimeMillis() - before));
    }

    public void json2Map() {
        Map<String, Object> jsonMap = JSON.parseObject(json);
        JSONArray jsonArray = (JSONArray) ((Map) jsonMap.get("sites")).get("site");
        log.info(((Map) jsonMap.get("sites")).get("site"));
        for (Object o : jsonArray) {
            log.info(o);
        }
    }
}
