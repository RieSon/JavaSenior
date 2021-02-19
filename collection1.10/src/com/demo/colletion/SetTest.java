package com.demo.colletion;

import org.junit.Test;

import java.util.*;

/**二，集合框架
 * --- collection接口:单列集合，用来存储一个个的对象
 *      ---Set接口：存储无序的，不可重复的数据 ---》数学中的集合
 *          ----HashSet:存储无序的，不可重复的数据；线程不安全的；可以存储null值
 *              ----LinkedHashSet:是HashSet的子类；遍历数据时，可以按照添加的顺序去遍历
 *          ----TreeSet:可以按照添加的对象的指定的属性，进行排序
 *
 *
 *   1，set接口中，没有额外定义方放，都是用Collection声明过的方法
 *      要求：向Set中添加的数据，其所在类一定要重写hashCode()和equals()方法
 *      要求：重写的hashCode()和equals()方法，尽可能要保证一致性：相等的对象必须要有相同的hash值
 *      以HashSet为例
 *      无序性：不是随机性，在底层不是根据索引顺序来存储的，而是根据数据的hash值来存储的
 *      不可重复性：保证添加的元素
 *
 *
 *   2，以hashset为例
 *   我们向HashSet中添加元素，首先调用元素a所在类的hashcode（）方法，计算a的hash值，
 *   此hash值，接着通过某种算法计算出在HashSet底层数组中存放的位置，（索引位置），
 *   判断索引位置上是否有相同的数据：
 *      如果没有其他元素，直接添加---->情况1
 *      如果有其他的元素，比较他们的hash值：
 *          如果不同：就添加成功---->情况2
 *          如果相同：就用新添加的元素的所在类的equals()方法与索引位置元素比较
 *              返回的是false就添加成功---->情况3
 *              是ture就添加失败
 *   对于情况2与情况3而言，与已经存在索引位置上的元素以链表的方式存储
 *   jdk1.7时：新元素放到数组中，指向之前元素
 *   jdk1.8时：老元素在数组中指向新元素
 *   hashSet 底层是数组+链表的结构
 * @author rieson
 * @create 2021-01-11-9:33
 */
public class SetTest {
    @Test
    public void test1(){
        Set<Object> set = new HashSet<>();
        set.add(123);
        set.add(456);
        set.add("qwe");
        set.add("asd");
        set.add(null);
        set.add(new Date());
        set.add(new String("unb"));
        System.out.println(set);
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        //LinkedHashSet 作为HashSet的子类，再添加数据时，每个数据还维护了，两个引用，
        // 记录此数据前后数据和，
        //优点：对于比较频繁的遍历操作，LinkedHashSet效率高于HashSet.
        Set<Object> set = new LinkedHashSet<>();
        set.add(123);
        set.add(456);
        set.add("qwe");
        set.add("asd");
        set.add(null);
        set.add(new Date());
        set.add(new String("unb"));
        System.out.println(set);
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test3(){
        //向TreeSet中添加数据，要求是相同类的对象
        //两种排序方式：自然排序：Comparable,定制排序：Comparator
        //自然排序中，比较两个对象是否相同的标准：compareTo()返回0，不是equals()
        //定制排序略
        Set<Object> set = new TreeSet<>();
        set.add(123);
        set.add(456);

        System.out.println(set);
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
