package com.briup.apps.app01.web.controller;

import com.briup.apps.app01.util.Message;
import com.briup.apps.app01.util.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/base")
public class BaseController {
    @ApiOperation("我是陈厚伯")
    @GetMapping("chb")
    public Message chb(){
        return MessageUtil.success("我是陈厚伯");
    }
    @ApiOperation("我是姚丽")
    @GetMapping("yl")
    public Message yl(){
        return MessageUtil.success("我是姚丽");
    }
    @ApiOperation("我是吴君怡")
    @GetMapping("wjy")
    public Message wjy(){
        return MessageUtil.success("我是吴君怡");
    }
    @ApiOperation("我是陈裕博")
    @GetMapping("cyb")
    public Message cyb(){
        return MessageUtil.success("我是陈裕博");
    }
    @ApiOperation("我是杨果")
    @GetMapping("yg")
    public Message yg(){
        return MessageUtil.success("我是杨果");
    }
    @ApiOperation("我是张杰")
    @GetMapping("zj")
    public Message zj(){
        return MessageUtil.success("我是张杰");
    }
    @ApiOperation("我是王耀聪")
    @GetMapping("wyc")
    public Message wyc(){
        return MessageUtil.success("我是王耀聪");
    }
}
