package com.demo.test;

import org.junit.Test;

import java.util.Arrays;

/**
 *一：说明：java中的对象，正常情况下，只能尽享比较：== 或 ！=。不能使用<,>的，但是在开发场景中
 *      我们需要多个对象进行排序，如何实现？使用两个接口中的人何一个：Comparable或者Comparator
 *二：Comparable接口与Comparator的使用对比
 *    comparable接口方式一旦确定，保证comparable接口实现类的对象在任何位置都可以比较大小
 *    comparator 接口属于临时性的比较
 *
 * @author rieson
 * @create 2021-01-03-12:47
 */
public class CompareTest {
    /*
    Comparable接口使用举例
     */
    @Test
    public void test1(){
        String[] str = new String[]{"AA","BB","MM","DD","CC","PP"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));

    }
}
