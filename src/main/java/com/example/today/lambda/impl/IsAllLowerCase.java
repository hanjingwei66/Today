package com.example.today.lambda.impl;

import com.example.today.lambda.interfaces.ValidationStrategy;

public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return false;
    }
}
