package com.example.template.controller;


import com.example.template.common.util.RedisUtil;
import com.example.template.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private RedisUtil redisUtil;
    Logger logger =  LoggerFactory.getLogger(TestController.class);


    @RequestMapping("/test001")
    public Object test1() {
        logger.debug("tttttttttttttt");
        redisUtil.set("test001","hello redis");

        return "login2";
    }
    @RequestMapping("/test002")
    public Object test2() {
        logger.debug("tttttttttttttt");
        Object test001 = redisUtil.get("test001");
        logger.error(test001.toString());

        return "login2";
    }

}
