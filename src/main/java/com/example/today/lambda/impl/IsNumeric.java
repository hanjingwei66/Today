package com.example.today.lambda.impl;

import com.example.today.lambda.interfaces.ValidationStrategy;

public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return false;
    }
}
