package com.demo.test;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1,jdk5.0新增特性
 * 2，在几何中使用泛型
 *  总结：
 *  集合接口或集合类在jdk1.5时都被修改为带泛型的结构。
 * @author rieson
 * @create 2021-01-13-9:53
 */
public class GenericTest {
    //在集合中使用泛型的情况
    //使用泛型时不能是基本数据类型，必须是类类型
    @Test
    public void test1() {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(123);
        objects.add(1);
        objects.add(12);
        objects.add(2);
        Iterator<Integer> iterator = objects.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2() {
        HashMap<String,Integer> objects = new HashMap<>();
        objects.put("qwe",123);
        objects.put("a",1);
        objects.put("s",12);
        objects.put("d",2);
        Set<Map.Entry<String, Integer>> entries = objects.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key+"="+value);
        }
    }
}
