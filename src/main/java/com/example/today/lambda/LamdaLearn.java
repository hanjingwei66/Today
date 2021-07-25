package com.example.today.lambda;

import com.example.today.modle.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamdaLearn {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 6, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(1, 2);
        List<int[]> collect = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        List<Stream<int[]>> collect1 = numbers1.stream().map(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Person("xiaoming",12));
        arrayList.add(new Person("xiaoming",14));
        arrayList.add(new Person("xiaoming",15));
        Integer sum = numbers1.stream().reduce(0, (a, b) -> a + b);
        Optional<Integer> reduce = numbers1.stream().reduce(Integer::max);
        System.out.println(sum);
        test();
    }

    public static void test(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> collect = transactions.stream().filter(i -> i.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(collect);
       // 交易员都在哪些不同的城市工作过？
        List<String> collect1 = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .map(trader -> trader.getCity()).distinct()
                .collect(Collectors.toList());
        System.out.println(collect1);
//        (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        transactions.stream().map(transaction -> transaction.getTrader())
                .filter(trader -> {return trader.getCity().equals("Cambridge");})
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
//        (4) 返回所有交易员的姓名字符串，按字母顺序排序。
//        (5) 有没有交易员是在米兰工作的？
        boolean b = transactions.stream().map(transaction -> transaction.getTrader())
                .filter(trader -> {
                    return trader.getCity().equals("Milan");
                })
                .anyMatch(trader -> {
                    return trader.getCity().equals("Milan");
                });
//        (6) 打印生活在剑桥的交易员的所有交易额。
        transactions.stream().map(transaction -> transaction.getValue())
                .collect(Collectors.toList())
                .forEach(System.out::println);
//        (7) 所有交易中，最高的交易额是多少？
        transactions.stream().map(Transaction::getValue).reduce(Integer::max);
//        (8) 找到交易额最小的交易。
        transactions.stream().max(Comparator.comparing(Transaction::getValue));
    }
}
