package com.example.javademo;

import com.example.javademo.enums.LogDescEnum;
import com.example.javademo.enums.PcOsVersion;
import org.json.JSONObject;
import org.junit.Test;

public class EnumTest {

    @Test
    public void enumTest(){
        System.out.println(LogDescEnum.LOGDESC_ADD);//打印枚举的名字
        //类.values得到的是所有的枚举实例，
        for (LogDescEnum e:LogDescEnum.values()) {
            System.out.println(e.getLogDescId()+":"+e.getLogDescName());
        }
        System.out.println(LogDescEnum.getLogDescNameById(1));
    }

    @Test
    public void test2(){
        System.out.println(PcOsVersion.getOsVersion("6.2.1"));
        System.out.println(PcOsVersion.getOsType("6.2.1"));
    }
}
