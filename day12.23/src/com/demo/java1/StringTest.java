package com.demo.java1;

import org.junit.Test;

/**
 * @author rieson
 * @create 2020-12-23-15:09
 */
public class StringTest {
    /*
    String：字符串，使用一对“”引起来表示
    1，String 声明为final,不可被继承
    2，String 实现了Serializable接口，表示字符串是支持序列化的
              实现了Comparable接口，表示String可以比较大小
    3，String在内部定义了final char[] value 用于存储字符串数据
    4，String 代表不可变的字符序列，简称：不可变性
    5，通过字面量的方式，给一个字符串赋值，此时的字符串声明在字符串常量池中
    6，字符串常量池中不会出现两个相同值的变量
     */
    @Test
    public void test1(){

        int a[] = {12,66,19,18,89};
        int sum ;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    sum =a[j];
                    a[j]=a[j+1];
                    a[j+1]=sum;

                }

            }

        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
