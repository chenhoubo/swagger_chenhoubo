package com.briup.apps.app01.util;

/**
 * @program: xn_app02
 * @description: 消息实体
 * @author: charles
 * @create: 2019-04-19 09:53
 **/

public class Message {
    private int code;   // 200 404 403 401
    private String message;
    private Object date;
    private long timestamp;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
