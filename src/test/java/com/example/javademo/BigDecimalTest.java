package com.example.javademo;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 对BigDecimal的所有的构造方法和使用方法进行测试
 * 常见的构造方法
 * BigDecimal(int)       创建一个具有参数所指定整数值的对象。
 * BigDecimal(double) 创建一个具有参数所指定双精度值的对象。
 * BigDecimal(long)    创建一个具有参数所指定长整数值的对象。
 * BigDecimal(String) 创建一个具有参数所指定以字符串表示的数值的对象。
 * <p>
 * 公共方法
 * add(BigDecimal)          BigDecimal对象中的值相加，然后返回这个对象。
 * subtract(BigDecimal)     BigDecimal对象中的值相减，然后返回这个对象。
 * multiply(BigDecimal)    BigDecimal对象中的值相乘，然后返回这个对象。
 * divide(BigDecimal)      BigDecimal对象中的值相除，然后返回这个对象。
 * toString()                将BigDecimal对象的数值转换成字符串。
 * doubleValue()          将BigDecimal对象中的值以双精度数返回。
 * floatValue()             将BigDecimal对象中的值以单精度数返回。
 * longValue()             将BigDecimal对象中的值以长整数返回。
 * intValue()               将BigDecimal对象中的值以整数返回
 * <p>
 * 计算方法
 * public BigDecimal add(BigDecimal value); //加法
 * public BigDecimal subtract(BigDecimal value); //减法
 * public BigDecimal multiply(BigDecimal value); //乘法
 * public BigDecimal divide(BigDecimal value); //除法
 * <p>
 * <p>
 * 格式化：
 * 由于NumberFormat类的format()方法可以使用BigDecimal对象作为其参数，
 * 可以利用BigDecimal对超出16位有效数字的货币值，百分值，以及一般数值进行格式化控制
 */
public class BigDecimalTest extends JavaDemoApplicationTests {


    @Test
        public void testConstruction() {
        //测试构造方法
        //参数为int
        BigDecimal bigDecimal = new BigDecimal(2);
        double k = 2.3;
        BigDecimal bDouble = new BigDecimal(k);
        //使用double作为参数，得到的结果会有损失，可以写成这样Double.toString(k)
        BigDecimal bdouble = new BigDecimal(Double.toString(k));
        //参数为String
        BigDecimal bString = new BigDecimal("2.3");

        System.out.println("bigDecimal=" + bigDecimal);
        System.out.println("bDouble=" + bDouble);
        System.out.println("bdouble="+bdouble);
        System.out.println("bString=" + bString);

    }

    @Test
    public void formatTest(){
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));
        System.out.println("利息:\t" + currency.format(interest));
    }

    @Test
    public void operationTest(){
        BigDecimal a = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.5");

        System.out.println("a + b =" + a.add(b));  //加法
        System.out.println("a - b =" + a.subtract(b));  //减法
        System.out.println("a * b =" + a.multiply(b));  //乘法
        System.out.println("a / b =" + a.divide(b));  //除法
    }
}
