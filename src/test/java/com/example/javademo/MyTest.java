package com.example.javademo;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

    class A {
        String name;
        List<B> bList;
    }

    class B {
        String name;
        List<C> cList;
    }

    static class C {
        String name;

        public void setName(String name) {
            this.name = name;
        }

        public C(String name) {
            this.name = name;
        }
    }


    // 题目：请编写下面静态方法，入参是A的集合，返回所有的C的集合（提示：可以使用java8特性）
    public static List<C> getAllCList(List<A> a) {
        List<C> c = new ArrayList<C>();
        for (A d:a) {
            c.add(new C(d.name));
        }
         return c;
    }




}