package com.example.today.lambda.impl;

import com.example.today.lambda.interfaces.ValidationStrategy;

public class Validator {
    ValidationStrategy validationStrategy;
    public Validator(ValidationStrategy validationStrategy) {
        this.validationStrategy=validationStrategy;
    }

    public static void main(String[] args) {
        new Validator((String s)->s.matches("a-z"));
    }
}
