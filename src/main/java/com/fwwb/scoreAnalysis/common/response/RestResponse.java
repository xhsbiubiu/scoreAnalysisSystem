package com.fwwb.scoreAnalysis.common.response;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RestResponse {

    private int code;

    private String msg;

//    private Page page;

    private Object data;

    private Date timestamp;

    public RestResponse() {
        data = new HashMap<String, Object>();
    }

    public void setRestCode(RestCode restCode) {
        this.code = restCode.getCode();
        this.msg = restCode.getMsg();
    }

    public void setData(Object dataObj) {
        this.data = dataObj;
    }

    public void addData(String name, Object dataObj) {
        Map<String, Object> map = null;
        if (data != null && data instanceof Map) {
            map = (Map<String, Object>) (Map<String, Object>) data;
        } else if (data == null) {
            map = new HashMap<>();
            data = map;
        }
        map.put(name, dataObj);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

//    public Page getPage() {
//        return page;
//    }

//    public void setPage(Page page) {
//        this.page = page;
//    }
//
//    public void setPageData(Page page) {
//        this.page = page;
//        this.data = page.getDatas();
//    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
