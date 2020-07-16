package com.lirui.controller;

import com.lirui.service.MySpringAopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// 实现aop注解的控制类
@Controller
public class MySpringAopController {

    @Autowired
    private MySpringAopService service;
    
    public int add(Integer x,Integer y) {
        System.out.println("求和结果为：" + service.add(x, y));
        return x + y;
    }
    
    
}
