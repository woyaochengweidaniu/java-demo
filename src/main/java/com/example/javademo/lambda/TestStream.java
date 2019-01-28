package com.example.javademo.lambda;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 对jdk8中的stream 流的方法进行测试
 * Stream接口中包含许多对流操作的方法，这些方法分别为：
 * filter()：对流的元素过滤
 * map()：将流的元素映射成另一个类型
 * distinct()：去除流中重复的元素
 * sorted()：对流的元素排序
 * forEach()：对流中的每个元素执行某个操作
 * peek()：与forEach()方法效果类似，不同的是，该方法会返回一个新的流，而forEach()无返回
 * limit()：截取流中前面几个元素
 * skip()：跳过流中前面几个元素
 * toArray()：将流转换为数组
 * reduce()：对流中的元素归约操作，将每个元素合起来形成一个新的值
 * collect()：对流的汇总操作，比如输出成List集合
 * anyMatch()：匹配流中的元素，类似的操作还有allMatch()和noneMatch()方法
 * findFirst()：查找第一个元素，类似的还有findAny()方法
 * max()：求最大值
 * min()：求最小值
 * count()：求总数
 */

public class TestStream {

    public static void main(String[] args) throws IOException {

        /**
         * 创建流的方式
         */
        //方式一：Stream stream = Stream.of("6","5","3","8","32")直接有.of方法创建一个可变长参数的流
        Stream stream = Stream.of("6","5","3","8","32");
        //方式二：Stream stream1 = Stream.empty()  直接创建一个空的流
        Stream stream1 = Stream.empty();
        //方式三：Stream stream2 = Arrays.stream(srt)，有数组创建流
        String[] srt = {"6","5","3","8","32"};
        Stream stream2 = Arrays.stream(srt);
        //方式四：通过文件创建流，使用java.nio.file.Files类中的很多静态方法都可以获取流，比如Files.lines()方法，该方法接收一个java.nio.file.Path对象，返回一个由文件行构成的字符串流
        //Stream<String> stream3 = Files.lines(Paths.get("text.txt"), Charset.defaultCharset());
        // 方式五：通过迭代器iteartor创建流
        Stream.iterate(0, n -> n + 2).limit(51).forEach(System.out::println);
        // 方式六：通过generate来创建流，iteartor，generate这两个方法生成的流都是无限流，没有固定大小，可以无穷的计算下去，在上面的代码中我们使用了limit()来避免打印无穷个值。
        Stream.generate(() -> "Hello Man!").limit(10).forEach(System.out::println);

        /**
         * 使用流的方法
         */
        Stream.of(1, 8, 5, 2, 1, 0, 9, 2, 0, 4, 8)
                // 对元素过滤，保留大于2的元素
                .filter(n -> n > 2)
                // 去重，类似于SQL语句中的DISTINCT
                .distinct()
                // 跳过前面1个元素,对前面去重后的结果而言
                .skip(1)
                // 返回开头2个元素，类似于SQL语句中的SELECT TOP
                .limit(2)
                // 对结果排序
                .sorted()
                //打印出来
                .forEach(System.out::println);

        /**
         * 查找和匹配
         */
        // 检查流中的任意元素是否包含字符串"Java"
        boolean hasMatch = Stream.of("Java", "C#", "PHP", "C++", "Python")
                .anyMatch(s -> s.equals("Java"));

        // 检查流中的所有元素是否都包含字符串"#"
        boolean hasAllMatch = Stream.of("Java", "C#", "PHP", "C++", "Python")
                .allMatch(s -> s.contains("#"));

        // 检查流中的任意元素是否没有以"C"开头的字符串
        boolean hasNoneMatch = Stream.of("Java", "C#", "PHP", "C++", "Python")
                .noneMatch(s -> s.startsWith("C"));

        // 查找元素
        Optional<String> element = Stream.of("Java", "C#", "PHP", "C++", "Python")
                .filter(s -> s.contains("C"))
                // .findFirst()     // 查找第一个元素
                .findAny();         // 查找任意元素




    }
}
