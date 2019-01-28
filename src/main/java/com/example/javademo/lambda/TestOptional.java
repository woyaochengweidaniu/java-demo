package com.example.javademo.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class TestOptional {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("张三",10,"女"));
        list.add(new User("张三",14,"女"));
        list.add(new User("王五",22,"男"));
        list.add(new User("老刘",9,"男"));

        //.forEach()相当于增强for循环，不过他可以自己判断里面的每个元素是什么类型
        list.stream().filter(s->s.getAge()>2).sorted((s1,s2)->s1.getAge()-s2.getAge()).forEach(f->{
            System.out.println(f);
        });

        //.collect(Collectors.toList())相当于Arrays.asList("java", "C++", "Python");中间可以加一些判断，进行过滤用filter ，s是代表里面的元素
        List<User> stringList = list.stream().filter(s -> s.getAge()>20).collect(Collectors.toList());
        IntSummaryStatistics statistics = list.stream().collect(Collectors.summarizingInt(User::getAge));
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(User::getSex,Collectors.counting()));
        System.out.println(statistics+"sssssssssssssssssssssssss");
        System.out.println(map);
        //将list转为流，然后进行过滤得到新的list
        stringList.forEach(s -> System.out.println("年龄大于20的时"+s.getUsername()));
        //测试optional的
        System.out.println(new TestOptional().testOptionals2());

    }



    public Object testOptionals(){
        User user = new User();
        if (user != null) {
            String userName = user.getUsername();
            if (userName != null) {
                return userName.toUpperCase();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Object testOptionals2(){
        User user = new User();
        user.setUsername("老猪");
        Optional<String> stringOptional = Optional.of("wo fhung");
        System.out.println(stringOptional.get());
        /**
         * Optional.empty() 创建一个空的optional对象
         * Optional.of("老刘")，可以创建一个不为空的optiona对象
         * Optional.ofNullable(user)不确定对象是否有没有可以用这种方法来接受
         */
        Optional<User> userOpt = Optional.ofNullable(user);
        Optional optional = userOpt.map(User::getUsername);
        System.out.println(optional+":"+optional.get());
        optional.ifPresent(System.out::println);
        /**
         * optional里面的方法
         * isPresent()，存在返回true
         * .get()，获取optional容器中的值
         * orElse("不存在")，  不存在返回默认的值
         * .map(user::getUserName)，第一个参数时对象，后面的时参数方法
         * .filter()   过滤方法，里面可以接受lambda表达式，如果filter()方法中的Lambda表达式成立，filter()方法会返回当前Optional对象值，否则，返回一个值为空的Optional对象。
         * flatMap()  于filter()非常的相似，
         * ifPresent()  ：一般用于将信息打印到控制台： optional.ifPresent(System.out::println)
         * orElseGet()  :与orElse()方法作用类似，区别在于生成默认值的方式不同。该方法接受一个Supplier<? extends T>函数式接口参数，用于生成默认值；
         * .orElseThrow()  :与前面介绍的get()方法类似，当值为null时调用这两个方法都会抛出NullPointerException异常，区别在于该方法可以指定抛出的异常类型，例子; .orElseThrow(()->new IllegalArgumentException("Argument 'str' cannot be null or blank."))
         */

        return userOpt.map(User::getUsername)
                .orElseThrow(()->new IllegalArgumentException("Argument 'str' cannot be null or blank."));
               // .orElse("返回默认值");
    }



}
