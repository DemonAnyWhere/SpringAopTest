package com.lirui.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MySpringAopDao {

    public int add(int x,int y) {
        return x + y;
    }
}
