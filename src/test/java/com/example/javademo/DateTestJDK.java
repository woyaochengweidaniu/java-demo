package com.example.javademo;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DateTestJDK {

    @Test
    public void testLocalDate(){
        //LocalDate.now()默认给出的是yyyy-mm-dd的形式
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);//2019-02-13
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getChronology());
        System.out.println(localDate.getEra());
        //System.out.println(localDate.getLong());
        System.out.println(LocalDate.now().getDayOfWeek());
        System.out.println(  DateFormatUtils.format(DateUtils.addDays(new Date(),0),"yyyy-MM-dd"));
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getMonthValue());
        //System.out.println(LocalDate.now().getMonth());
        System.out.println(LocalDate.now().getDayOfWeek().getValue());
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
        System.out.println(localDateTime.getMonthValue()+"###########################");
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

    @Test
    public void testDateUtils(){
        System.out.println(DateFormatUtils.format(DateUtils.addDays(new Date(),1),"yyyy-MM-dd"));
        System.out.println(DateFormatUtils.format(DateUtils.addDays(new Date(),-5),"yyyy-MM-dd"));
        System.out.println(DateFormatUtils.format(DateUtils.addWeeks(new Date(),1),"yyyy-MM-dd"));
        System.out.println(DateUtils.addDays(new Date(),0));
        System.out.println();
        System.out.println();

    }

    @Test
    public void testLang3() throws ParseException {
        System.out.println(DateFormatUtils.format(DateUtils.parseDate("2019-12-2","yyyy-MM-dd"),"yyyy-MM-dd"));

//        Date startTime = DateUtils.parseDate("2019-1","yyyy-MM");
//        Date endTime = DateUtils.addDays(startTime,30);
//        System.out.println(startTime);
//        System.out.println(endTime);

        //LocalDateTime startTime = LocalDateTime.now();
        //LocalDateTime endTime = LocalDateTime.of(startTime.getYear(),startTime.getMonthValue(),startTime.getDayOfMonth(),0,0);
        Date startTime = DateUtils.parseDate("2019-8-21","yyyy-MM-dd");
        System.out.println(DateUtils.addDays(new Date(),0));
        //System.out.println(endTime);
    }

    @Test
    public void testTodayAndEndDay(){
        //获取当天的开始时间和结束时间

        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println(today_start);
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println(today_end);

//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime zdt = today_start.atZone(zoneId);
//        System.out.println(Date.from(zdt.toInstant()));
    }

    @Test
    public void test9() throws InterruptedException {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        Date zero = calendar.getTime();
//        System.out.println(DateFormatUtils.format(zero,"yyyy-MM-dd"));

//        System.out.println( LocalDateTime.of(LocalDate.now().minusDays(1),LocalTime.MIN));
//        System.out.println( LocalDateTime.of(LocalDate.now(),LocalTime.MIN));
//        System.out.println(LocalDate.now().plusDays(1));
//        LocalDateTime start = LocalDateTime.now();
//        System.out.println("####################################");
//        Thread.sleep(5000);
//        Duration duration = Duration.between(start,LocalDateTime.now());
        //System.out.println(duration.);
        System.out.println(LocalDate.now().minusDays(19).with(TemporalAdjusters.firstDayOfMonth()).toString());
    }
}
