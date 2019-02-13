package com.example.javademo;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTestJDK {

    @Test
    public void testLocalDate(){
        //LocalDate.now()默认给出的是yyyy-mm-dd的形式
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);//2019-02-13
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getChronology());
        System.out.println(localDate.getEra());
        //System.out.println(localDate.getLong());
    }

    @Test
    public void testLocalTime(){
        //LocalDateTime代表着一个日期-时间，没有时区的表示
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.getDayOfYear());
        //一个月中的第几天
        System.out.println(localDateTime.getDayOfMonth());
        //一个星期中的第几天
        System.out.println(localDateTime.getDayOfWeek());
        //一年中的第几个月
        System.out.println(localDateTime.getMonthValue());
        //英文的月分
        System.out.println(localDateTime.getMonth());
        //从凌晨开始算起多少个小时
        System.out.println(localDateTime.getHour());
        //几点几分里的几分
        System.out.println(localDateTime.getMinute());
        //几秒
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.getNano());
        //当前时间戳
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testInsant(){
        Instant instant = Instant.now();
        System.out.println(instant.toString());
        //加五秒
        System.out.println(instant.plus(Duration.ofMillis(5000)).toString());
        //减五秒
        System.out.println(instant.minus(Duration.ofMillis(5000)).toString());
        //减10毫秒
        System.out.println(instant.minusSeconds(10).toString());
        System.out.println(instant.minusMillis(10));
    }

    @Test
    public void testDuration(){
        Duration duration = Duration.ofMillis(5000);
        System.out.println(duration.toString());
        duration = Duration.ofSeconds(60);
        System.out.println(duration.toString());     //PT1M

        duration = Duration.ofMinutes(10);
        System.out.println(duration.toString());     //PT10M

        duration = Duration.ofHours(2);
        System.out.println(duration.toString());     //PT2H

        duration = Duration.between(Instant.now(), Instant.now().plus(Duration.ofMinutes(10)));
        System.out.println(duration.toString());  //PT10M
    }
}
