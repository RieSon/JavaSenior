package com.demo.colletion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 一，集合框架
 * -- collection接口:单列集合，用来存储一个个的对象
 *    ---List接口：存储有序的，可重复的数据 ---》"动态"对象
 *       ---ArrayList:作为List的主要实现类，线程是不安全的，效率高；底层使用的是Object[]存储
 *       ---LinkedList：对于频繁的插入，删除操作时，使用此效率要比Arraylist高；底层使用双向链表存储，
 *       ---vector：作为List的古老实现类，线程是安全的，效率相对低；底层使用的是Object[]存储
 *
 * 2,ArrayList的源码分析：
 * 2.1 jdk1.7情况下
 *       ArrayList list = new ArrayList();底层创建了长度是10的object[]数组elementData
 *       list.add(123);elementData[0] = new Integer(123);
 *       ....
 *       list(123456);如果此次的添加导致底层elementData数组容量不足，则扩容。
 *       默认情况下，扩容为原容量的1.5倍，同时需要将原数组中的数据复制到新的数组中。
 *       结论：建议开发中使用带参数的构造器：ArrayList list = new ArrayList(int capacity)
 * 2.2 jdk1.8中的变化：
 *     ArrayList list = new ArrayList();底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *     list.add(123);第一次调用add()方法时，底层才创建了长度为10的数组，并将数据123，添加到elementData数组中
 *     后续的添加跟扩容跟1.7无异
 * 2.3 小结：jdk7中的ArrayList的对象的创建类似于单例模式的饿汉式，
 *      而jdk8时使用的是饿汉式，延迟了创建数组，节省内存
 *
 * 3，LinkedList源码分析：
 *      LinkedList list = new LinkedList();内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123);将123封装带Node中，创建了Node对象。
 *      其中，Node定义为：体现了LinkedList 的双向链表说法
 *
 *
 *
 *
 *
 *
 *
 * @author rieson
 * @create 2021-01-10-17:41
 */
public class ListTest {
   // 4,List接口中的常用方法

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(465);
        list.add("asd");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for( Object o : list){
            System.out.println(o);
        }
    }
    @Test
   public void test2() {

       ArrayList list = new ArrayList();
       list.add(123);
       list.add(465);
       list.add("asd");
       list.add(new String("hello"));
       list.add(123);
       System.out.println(list);
       //int indexOf(Object obj):返回obj首次出现的位置
        System.out.println(list.indexOf(123));
       //int lastIndexOf(Object obj):返回obj首次出现的位置
        System.out.println(list.lastIndexOf(123));
        // Object remove(int index):移除指定index位置的元素，并返回此元素
         System.out.println(list.remove(2));
         //Object set(int index,object obj ):修改指定index位置的元素为obj
        System.out.println(list.set(1,"asd"));
        //List subList(int fromIndex,int toIndex):返回fromIndex到toIndex位置的左臂右开区间的值
        List list1 = list.subList(2, 4);
        System.out.println(list1);


    }


    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(465);
        list.add("asd");
        list.add(new String("hello"));
        list.add(123);
        System.out.println(list);
        //void add(int index,Object ele):在index位置插入 ele元素
        list.add(2,"qwe");
        //boolean addAll(int index,Collection clo):从index位置开始给clo元素全部添加到list中
        List<Integer> integers = Arrays.asList(1, 3, 2);
        list.addAll(2,integers);
        System.out.println(list);
        System.out.println( list.get(3));

    }
}
