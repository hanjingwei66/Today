package com.example.today.impl;

import com.example.today.service.HotSwappable;
import org.springframework.stereotype.Service;

@Service
public class HotSwappableImpl implements HotSwappable {
    @Override
    public void hello() {
        System.out.println("hello world");
    }
}
