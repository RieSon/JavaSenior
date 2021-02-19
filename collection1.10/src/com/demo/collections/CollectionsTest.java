package com.demo.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Collections工具类的：
 *   操作collection，List,Map等集合的工具类
 * @author rieson
 * @create 2021-01-12-14:45
 */
public class CollectionsTest {
    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(1);
        list.add("asd");
        list.add(false);
        list.add('a');
        System.out.println(list);
        List list1 = Collections.synchronizedList(list);



    }
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(1);
        list.add("asd");
        list.add(false);
        list.add('a');
        System.out.println(list);
        //reverse(list);反转排序
        //Collections.reverse(list);
        //shuffle(list)：随机排序
      //  Collections.shuffle(list);
        //sort(list):根据自然顺序对List集合元素按升序排序
      //  Collections.sort(list);
       // Collections.sort(list);//还可以定制排序

        //swap(list,1,2);指定元素调换位置
        Collections.swap(list,1,2);
        //max/min(list);最大 最小值
       // Collections.max(list);
        //frequency(list,1);返回集合中指定元素的个数
       // Collections.frequency(list,1);
        //copy(dest,list);
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(list);
        System.out.println(dest);
    }
}
