package com.test.aop.aop;

import com.test.aop.ClientService;

public class Man implements ClientService.People {
    @Override
    public String getType() {
        System.out.println("男人" );
        return "男人";
    }
}
