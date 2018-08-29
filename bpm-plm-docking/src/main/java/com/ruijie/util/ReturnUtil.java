package com.ruijie.util;

import net.sf.json.JSONObject;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */

public class ReturnUtil {

    private ReturnUtil(){}

    public static String getJsonResultStr(int statusCode,Object data, String errMsg){
        JSONObject result = new JSONObject();
        result.put("status", statusCode);
        if(data != null){
            result.put("data", data);
        }else{
            result.put("data", "[]");
        }
        result.put("err", errMsg);
        return result.toString();
    }
}
