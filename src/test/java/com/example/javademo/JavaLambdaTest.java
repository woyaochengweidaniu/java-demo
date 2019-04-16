package com.example.javademo;


import com.example.javademo.pojo.Student;
import com.example.javademo.utils.DataUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class JavaLambdaTest extends JavaDemoApplicationTests{


    @Test
    public void constructionTest(){

    }


    @Test
    public void filter(){
        //找出武汉大学的玄德
        List<Student> list = DataUtils.getData().stream()
                .filter(student -> "武汉大学".equals(student.getSchool())&&"玄德".equals(student.getName()))
                .collect(Collectors.toList());
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void distinct(){
        //找出年龄是偶数的学生并且去重
//         DataUtils.getData().stream()
//                 .filter(student -> student.getAge()%2==0)
//                 .distinct().collect(Collectors.toList()).forEach(student -> {
//             System.out.println(student);
//         });

        List<Student> list = DataUtils.getData().stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() ->new TreeSet<>(Comparator.comparing(Student::getName))),ArrayList::new
        ));
        list.forEach(student -> System.out.println(student));
    }
    @Test
    public void limit(){
        //找出年龄是偶数的学生只展示前两个
        DataUtils.getData().stream()
                .filter(student -> student.getAge()%2==0)
                .limit(2)
                .collect(Collectors.toList()).forEach(student -> {
            System.out.println(student);
        });
    }
    @Test
    public void sorted(){
        //找出年龄是偶数的学生并且按照年纪排序降序只展示前两个
        DataUtils.getData().stream()
                .filter(student -> student.getAge()%2==0)
                //排序，sorted里面是定义一个比较器
                .sorted((s1,s2)->s2.getGrade()-s1.getGrade())
                .limit(2)
                .distinct().collect(Collectors.toList()).forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void skip(){
        //找出年龄是偶数的学生并且按照年纪排序降序前面两个不展示
        DataUtils.getData().stream()
                .filter(student -> student.getAge()%2==0)
                .sorted((s1,s2)->s2.getGrade()-s1.getGrade())
                .skip(2)
                .collect(Collectors.toList()).forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void map(){
        //找出是计算机科学专业有多少人
        DataUtils.getData().stream()
                .filter(student -> student.getMajor().equals("计算机科学"))
                .map(Student::getName)
                .collect(Collectors.toList()).forEach(student -> {
            System.out.println(student);
        });
    }

    @Test
    public void mapToInt(){
        //找出是计算机科学专业的学生的年龄之和
        System.out.println(DataUtils.getData().stream()
                .filter(student -> student.getMajor().equals("计算机科学"))
                .mapToInt(Student::getAge)
                .sum());
    }

    @Test
    public void flatMap(){
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());

        distinctStrs.forEach(s -> System.out.println(s));
    }

    @Test
    public void allMatch(){
        //检查是否所有的学生年龄都大于20岁
        System.out.println(DataUtils.getData().stream().allMatch(student -> student.getAge() > 20));
    }

    @Test
    public void anyMatch(){
        //检查是否有来自武汉大学的学生
        System.out.println(DataUtils.getData().stream().anyMatch(student -> "武汉大学".equals(student.getSchool())));
    }

    @Test
    public void noneMathch(){
        //检查是否不存在计算机科学专业的学生
        System.out.println(DataUtils.getData().stream().noneMatch(student ->"计算机科学".equals(student.getMajor())));
    }

    @Test
    public void findFirst(){
        //返回满足条件的第一个
        System.out.println(DataUtils.getData().stream().filter(student -> "武汉大学".equals(student.getSchool())).findFirst().get());
    }

    @Test
    public void findAny(){
        //返回满足条件的第一个,在顺序流中返回的对象和findFirst的是一样的
        System.out.println(DataUtils.getData().stream().filter(student -> "武汉大学".equals(student.getSchool())).findAny().get());
    }

    @Test
    public void reduce(){
        // 归约操作
        int totalAge = DataUtils.getData().stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getAge)
                //统计年龄之和：reduce归约，里面两个参数相加，第一个是初始值
                //.reduce(1, (a, b) -> a + b);
                //若没有初始值可以省略简写成下面的形式，但是得到的是一个optional对象，需要获取里面的值用get
                .reduce(Integer::sum).get();
        System.out.println(totalAge);




    }

    @Test
    public void count (){
        //有多少学生
        System.out.println(DataUtils.getData().stream().count());

    }

    @Test
    public void maxAndMinAndAvg (){
        //年龄最大的学生，注意这里得到的是Optional对象
        System.out.println(DataUtils.getData().stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge))));
        //年龄最小的学生
        System.out.println(DataUtils.getData().stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge))));
        //对所有学生的年龄求总和
        System.out.println(DataUtils.getData().stream().collect(Collectors.summingInt(Student::getAge)));
        //对所有的学生的年龄求平均值..对应的还有averagingLong、averagingDouble。
        System.out.println(DataUtils.getData().stream().collect(Collectors.averagingInt(Student::getAge)));
        //求出最大，最小，平均，总和
        System.out.println(DataUtils.getData().stream().collect(Collectors.summarizingInt(Student::getAge)));

    }

    @Test
    public void joining (){
        //字符串拼接
        System.out.println(DataUtils.getData().stream().map(Student::getName).collect(Collectors.joining(",","[","]")));
        //直接转成set集合跟上面不一样，上面是一个String 而这个是一个set集合
        System.out.println(DataUtils.getData().stream().map(Student::getName).collect(Collectors.toSet()));
    }

    @Test
    public void groupingBy (){
        //可以进行一级分组
        Map<String, List<Student>> groups = DataUtils.getData().stream().collect(Collectors.groupingBy(Student::getSchool));
        System.out.println(groups);
        System.out.println("###############################");
        //进行三级分组
        Map<String, Map<String, Map<Integer, List<Student>>>> groups2 = DataUtils.getData().stream().collect(
                Collectors.groupingBy(Student::getSchool,  // 一级分组，按学校
                        Collectors.groupingBy(Student::getMajor,   // 二级分组，按专业
                                Collectors.groupingBy(Student::getGrade)))); //三级分组
        groups.forEach((s, students) -> System.out.println(s+":"+students));
        groups2.forEach((s, students) -> System.out.println(s+":"+students));
        //实际上在groupingBy的第二个参数不是只能传递groupingBy，还可以传递任意Collector类型，比如我们可以传递一个Collector.counting，用以统计每个组的个数：
        System.out.println("--------------------------------------------------------------------");
        //统计每个学校的每个专业有多少学生
        Map<String,Map<String,Long>> mapMap = DataUtils.getData().stream().collect(Collectors.groupingBy(Student::getSchool,
                Collectors.groupingBy(Student::getMajor,Collectors.counting())));
        mapMap.forEach((s, stringLongMap) -> System.out.println(s+":"+stringLongMap));
    }

    @Test
    public void partitioningBy (){
        //分区，将学生分成武汉大学和非武汉大学的
       Map<Boolean,List<Student>> map = DataUtils.getData().stream().collect(Collectors.partitioningBy(student->"武汉大学".equals(student.getSchool())));
       map.forEach((aBoolean, students) -> System.out.println(aBoolean+":"+students));
    }
    /**
     * 并行流式数据处理
     *
     * 流式处理中的很多都适合采用 分而治之 的思想，从而在处理集合较大时，极大的提高代码的性能，java8的设计者也看到了这一点，所以提供了 并行流式处理。
     * 上面的例子中我们都是调用stream()方法来启动流式处理，java8还提供了parallelStream()来启动并行流式处理，parallelStream()本质上基于java7的Fork-Join框架实现，
     * 其默认的线程数为宿主机的内核数。
     *
     * 启动并行流式处理虽然简单，只需要将stream()替换成parallelStream()即可，但既然是并行，就会涉及到多线程安全问题，
     * 所以在启用之前要先确认并行是否值得（并行的效率不一定高于顺序执行），另外就是要保证线程安全。此两项无法保证，
     * 那么并行毫无意义，毕竟结果比速度更加重要，以后有时间再来详细分析一下并行流式数据处理的具体实现和最佳实践。
     */



}
