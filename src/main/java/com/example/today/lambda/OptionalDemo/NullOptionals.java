package com.example.today.lambda.OptionalDemo;

import java.util.HashMap;
import java.util.Optional;

public class NullOptionals {
    public static void main(String[] args) {
        String s=null;
        HashMap map = new HashMap();
        map.put("isnull",null);
        map.put("1","");
        boolean present = Optional.ofNullable(map.get("isnull")).isPresent();
        Optional.ofNullable(map.get("isnull")).ifPresent(
                System.out::println
        );
        System.out.println(present);
    }
}
