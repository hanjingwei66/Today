package com.example.today.lambda.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2021, 7, 19);
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now().toLocalDate());
        System.out.println(LocalDateTime.now().toLocalTime());
        System.out.println(LocalDateTime.now());
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = LocalDateTime.now().format(pattern);
        LocalDateTime parse = LocalDateTime.parse(format, pattern);
        System.out.println(format);
        System.out.println(parse);
    }
}
