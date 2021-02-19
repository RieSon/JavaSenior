package com.demo.colletion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 *集合元素的遍历操作，使用迭代器Iterator接口
 * @author rieson
 * @create 2021-01-10-16:18
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection con = new ArrayList<>();
        //add(Object e):将元素e添加到集合con中
        con.add(1);
        con.add("asd");
        con.add(new Date());

        Iterator iterator = con.iterator();
        //方式一
      //  System.out.println(iterator.next());
        //方式二
//        for (int i = 0; i < con.size(); i++) {
//            System.out.println(iterator.next());
//        }
       //方法三 推荐
        System.out.println("+******************+");
        //hasNext()判断是否还有下一个元素
        while (iterator.hasNext()){
            //next():指针下移，将下移后的集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        Collection con = new ArrayList<>();
        //add(Object e):将元素e添加到集合con中
        con.add(1);
        con.add("asd");
        con.add(new Date());

        Iterator iterator = con.iterator();
        //删除集合中“asd”
        while (iterator.hasNext()){
            Object next = iterator.next();
            if ("asd".equals(next)){
                iterator.remove();
            }


        }
        Iterator iterator1 = con.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
