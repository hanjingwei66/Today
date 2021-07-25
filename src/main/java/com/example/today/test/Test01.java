package com.example.today.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        hashMap.put(1,list);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(hashMap.get(1));

    }
}
