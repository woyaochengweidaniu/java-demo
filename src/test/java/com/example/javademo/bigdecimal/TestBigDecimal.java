package com.example.javademo.bigdecimal;

import com.example.javademo.JavaDemoApplicationTests;
import com.example.javademo.pojo.Student;
import com.example.javademo.utils.DataUtils;
import org.junit.Test;

import java.util.stream.Collectors;


public class TestBigDecimal extends JavaDemoApplicationTests {

    @Test
    public void testGroupByAfterBigdecimal(){
        //自定义实现对分组后的集合，属性为bigdecmal进行相加
        System.out.println(DataUtils.getData().stream().collect(Collectors.groupingBy(Student::getSchool,CollectorsUtil.summingBigDecimal(Student::getMoney))));
//        DataUtils.getData().stream().collect(Collectors.groupingBy(Student::getSchool,CollectorsUtil.summingBigDecimal()))
    }
}
