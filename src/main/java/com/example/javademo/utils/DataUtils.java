package com.example.javademo.utils;


import com.example.javademo.pojo.Student;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    public static List<Student> getData(){
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学",new BigDecimal(20)));
                add(new Student(20160002, "伯约", 20, 2, "信息安全", "武汉大学",new BigDecimal(20)));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学",new BigDecimal(20)));
                add(new Student(20160004, "云长", 21, 1, "信息安全", "武汉大学",new BigDecimal(20)));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学",new BigDecimal(20)));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学",new BigDecimal(20)));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学",new BigDecimal(20)));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学",new BigDecimal(20)));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学",new BigDecimal(20)));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学",new BigDecimal(20)));
            }
        };
        return students;
    }
}
