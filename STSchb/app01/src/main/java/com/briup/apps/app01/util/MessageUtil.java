package com.briup.apps.app01.util;

import java.util.Date;

/**
 * @program: xn_app02
 * @description: 统一消息返回
 * @author: charles
 * @create: 2019-04-19 09:50
 **/

public class MessageUtil {

    public static Message success(Object data) {
        Message message = new Message();
        message.setCode(200);
        message.setDate(data);
        message.setMessage("success");
        message.setTimestamp(new Date().getTime());
        return message;
    }
    public static Message success(String msg) {
        Message message = new Message();
        message.setCode(200);
        message.setDate(null);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    public static Message success(String msg,Object data) {
        Message message = new Message();
        message.setCode(200);
        message.setDate(data);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    public static Message error(String msg) {
        Message message = new Message();
        message.setCode(500);
        message.setDate(null);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }



}
