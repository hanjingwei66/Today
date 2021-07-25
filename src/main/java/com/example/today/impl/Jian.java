package com.example.today.impl;

import com.example.today.service.HotSwappable;
import com.example.today.service.MakeWuqi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Jian implements MakeWuqi {
    public final HotSwappable hotSwappable;

    public Jian(@Qualifier("byeHotSwappableImpl") HotSwappable hotSwappable) {
        this.hotSwappable = hotSwappable;
    }

    @Override
    public void make() {
        hotSwappable.hello();
        System.out.println("剑");
    }
}
