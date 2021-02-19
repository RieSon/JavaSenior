package com.demo.colletion;

import org.junit.Test;

import java.util.*;

/**
 * 一，集合框架的概述：
 * 1，集合数组都是对多个数据进行存储，简称java容器
 * 说明：此时的存储是作用与内存层面上的，不涉及持久化的存储（txt,jpg,avi,数据库，硬盘等等）
 * 2.1，数组在存储多个数据的特点：
 * >初始化时，数组长度需要确定
 * >数组一旦定义好，其元素就确定了，我们只能操作已经确定了的元素数据
 * 2.2，数组在存储多个数据的缺点：
 * >一旦初始化后就确定了长度，不可修改
 * >数组中提供的方法非常有限，对于添加，删除，插入数据等操作，非常的不便。并且效率不高
 * >获取数组中实际元素的个数的需求，数组没有现成的属性或方法
 * >数组存储数据的特点：有序，可重复，对于无序，不可重复的需求，不能满足
 * 二，集合框架
 * -- collection接口:单列集合，用来存储一个个的对象
 *          ---List接口：存储有序的，可重复的数据 ---》"动态"对象
 *                  ----ArrayList,LinkedList,vector
 * ---Set接口：存储无序的，不可重复的数据 ---》数学中的集合
 * ----HashSet,LinkedHashSet,TreeSet
 * -- Map接口：双列集合，用来存储一对（key---value）一对的数据
 * ----HashTable,HashMap,TreeMap,LinkedHashMap,Properties
 *
 * @author rieson
 * @create 2021-01-10-11:34
 */
public class CollectionTest {
    @Test
    public void test1() {

        Collection con = new ArrayList<>();
        //add(Object e):将元素e添加到集合con中
        con.add(1);
        con.add("asd");
        con.add(new Date());

        //size():获取添加的元素的个数
        System.out.println(con.size());

        //addAll():将con1中的元素全部添加到当前几何中
        Collection con1 = new ArrayList<>();
        con1.add(1);
        con1.add(2);
        con.addAll(con1);
        System.out.println(con.size());
        //clear():清空集合中的元素
        //con.clear();
        //isEmpty():判断当前集合是否为空
        System.out.println(con.isEmpty());
        //contains(Object o):判断当前集合中是否包含o
        //我们在判断时，会调用o中对象所在类的equals()方法
        //向Collection接口实现类的对象中添加o时，要求o所在的类要重写equals()方法
        boolean asd = con.contains("asd");
        System.out.println(asd);
        System.out.println(con.contains(new Date()));
        //containsAll:判断集合con1中当前集合中是否全部包含，全部包含返回true,反而为false
        con.containsAll(con1);

    }

    @Test
    public void test2() {
        Collection con = new ArrayList<>();
        //add(Object e):将元素e添加到集合con中
        con.add(1);
        con.add("asd");
        con.add(new Date());
        con.add(false);

        //remove(Object o):删除集合中对应的元素
        con.remove(1);
        //removeAll(Collection con1):删除con与con1中的相同的数据
        Collection con1 = new ArrayList<>();

        con1.add(1);
        con1.add(true);
        con.removeAll(con1);
        System.out.println(con1);
        System.out.println(con);
    }

    @Test
    public void test3() {
        Collection con = new ArrayList<>();

        con.add(1);
        con.add("asd");
        con.add(new Date());
        con.add(false);

        //retainAll(Collection con1):获取当前集合与con集合的交集，并返回给当前集合
//        Collection con1 = Arrays.asList(1,1234);
//        con.retainAll(con1);
//        System.out.println(con);
        Collection con1 = new ArrayList<>();

        con1.add(1);
        con1.add("asd");
        con1.add(new Date());
        con1.add(false);
        //equals(Object o):比较两个集合里面的元素是否相等

        System.out.println(con.equals(con1));
    }
    @Test
    public void test4(){
        Collection con = new ArrayList<>();

        con.add(1);
        con.add("asd");
        con.add(new Date());
        con.add(false);
        //hashCode():返回当前对象的hash值
        System.out.println(con.hashCode());
        //toArray():集合转换成数组
        Object[] objects = con.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        //数组转换成集合
        List<String> strings = Arrays.asList(new String[]{"aa", "bb", "CC"});
        System.out.println(strings);

        //iterator():返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中测试
    }
}
