package com.lirui.service.impl;

import com.lirui.dao.MySpringAopDao;
import com.lirui.service.MySpringAopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySpringAopServiceImpl implements MySpringAopService {

    @Autowired
    private MySpringAopDao dao;

    public int add(int x,int y) {
        return dao.add(x,y);
    }
}
