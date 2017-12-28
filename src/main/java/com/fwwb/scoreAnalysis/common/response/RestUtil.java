package com.fwwb.scoreAnalysis.common.response;


import java.util.Date;

/**
 * Created by Administrator on 2016/3/1.
 */
public class RestUtil {

    public static RestResponse getResponse() {
        RestResponse response = new RestResponse();
        response.setRestCode(RestCode.SUCCESS);
        response.setTimestamp(new Date());
        return response;
    }

    public static RestResponse getResponse(String msg) {
        RestResponse response = new RestResponse();
        response.setRestCode(RestCode.SUCCESS);
        response.setMsg(msg);
        response.setTimestamp(new Date());
        return response;
    }

    public static RestResponse getResponse(RestCode restCode){
        RestResponse response = new RestResponse();
        response.setRestCode(restCode);
        response.setTimestamp(new Date());
        return response;
    }

    public static RestResponse getResponse(RestCode restCode, String msg){
        RestResponse response = new RestResponse();
        response.setRestCode(restCode);
        response.setMsg(msg);
        response.setTimestamp(new Date());
        return response;
    }
}
