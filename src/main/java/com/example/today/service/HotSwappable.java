package com.example.today.service;

import com.example.today.myAnnotation.Idempotent;
@Idempotent
public interface HotSwappable {
    @Idempotent
    void hello();
}
