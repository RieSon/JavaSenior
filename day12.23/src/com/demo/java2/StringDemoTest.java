package com.demo.java2;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rieson
 * @create 2020-12-26-15:37
 */

public class StringDemoTest {
    @Test
    public void test(){
        //实例化SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        //格式化：日期---》字符串
        Date date = new Date();
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}

