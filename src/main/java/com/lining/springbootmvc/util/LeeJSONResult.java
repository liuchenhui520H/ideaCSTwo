package com.lining.springbootmvc.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LeeJSONResult {
    private static final ObjectMapper objectMapper=new ObjectMapper();
    private Integer status;
    private String msg;
    private Object data;
    private String ok;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public void setData(Object data) {
        this.data = data;
    }

    public static LeeJSONResult build(Integer status, String msg, Object data){
    return new LeeJSONResult(status,msg,data);
}
    public static LeeJSONResult ok(Object data){
        return new LeeJSONResult(data);
    }
    public static LeeJSONResult ok(){
        return new LeeJSONResult(null);
    }
    public static LeeJSONResult errorMsg(String msg){
        return new LeeJSONResult(500,msg,null);
    }
    public static LeeJSONResult errorMap(Object data){
        return new LeeJSONResult(501,"error",data);
    }
    public static LeeJSONResult errorTokenMsg(String msg){
        return new LeeJSONResult(502,msg,null);
    }
    public static LeeJSONResult errorException(String msg){
        return new LeeJSONResult(555,msg,null);
    }

    public LeeJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public LeeJSONResult() {
    }
    public LeeJSONResult(Object data) {
        this.status = 200;
        this.msg = "ok";
        this.data = data;
    }

}
