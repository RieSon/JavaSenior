package com.demo.map;

import org.junit.Test;

import java.util.*;

/**
 * 1， Map接口：双列集合，用来存储一对（key---value）一对的数据
 *     ------HashMap:作为Map的主要实现类；线程不安全，效率高；可以存储null的key value值
 *          ----- LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历
 *                          原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个
 *                          元素，对于频繁的遍历操作，此类要效率要高与HashMap
 *     -----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历，此时考虑key的自然排序，或定制排序
 *                  底层使用的是红黑树
 *      ----Hashtable:作为Map的古老实现类；线程安全，效率低；不能存储null的key value值
 *          ----- Properties:常用来处理配置文件。key和value都是String类型的。
 *
 *      HashMap的底层：数组+链表（1.7）
 *                    数组+链表+红黑树（1.8）
 *
 *      面试题：
 *      1，HashMap的底层实现原理
 *      2，HashMap与Hashtable的异同
 *      3，
 * 2，Map结构的理解：
 *      Map 中的key：无序的，不可重复的，使用Set存储所有的Key ---》Key所在的类需要重写equals（）方法和hashcode（）方法
 *      value：无序的，可重复的，使用Collection存储所有的value---》value所在类需要重写equals（）方法
 *      一个键值对：key-value构成一个Entry对象
 *      Map中的Entry：无序的，不可重复的，使用Set来存储所有的Entry
 *
 * 3，HashMap的底层实现原理：
 *       （jdk7）
 *      HashMap map = new HashMap();
 *      在实例化以后，底层创建了长度是16的一维数组Entry[] table.
 *      ....已经执行过很多次put...
 *      map.put(key1,value1):
 *      首先调用的key1所在类的hashCode（）计算key1的哈希值此哈希值经过某种算法计算以后，得到Entry数组中的存放位置
 *      如果此位置上为空，此时的key1-value1添加成功，-----情况1
 *      如果此位置上有一个，或多个元素（以链表的方式存储），比较key1和已经存在的一个或多个元素的key的哈希值
 *              如果key1的哈希值与所有的元素的哈希值都不同时，则key1添加成功-----情况2
 *              如果key1的哈希值与其中任何一个元素的哈希值一样时，继续比较，调用key1所在类的equals（）方法
 *              如果返回的是false，则key1添加成功。----情况3
 *              如果返回的是true，此时已经存储的key，保持不变，value值被key1的value替换
 *         补充：关于情况2，情况3：此时的key1-value1和原来的数据以链表的方式存储
 *
 *         再不断的添加过程中，会涉及到扩容问题，当超出临界值时，并且下一个添加的索引位置上不为空
 *         默认的扩容方式：扩容为原来容量的2倍，将原有的数据复制过来
 *
 *        (jdk8)相较于jdk7底层实现方面的不同：
 *
 *  *      1，new HashMap()；在实例化以后，底层没有创建了长度是16的一维数组Entry[] table.
 *         2，jdk8底层的数组是：Node[],而非Entry[]
 *         3，首次使用put（）方法时，底层创建建了长度是16的数组
 *         4，jdk7底层只有：数组+链表。jdk8中的底层结构：数组+链表+红黑树。
 *              当数组的某一个索引位置上的元素以链表的方式存在的个数大于8 且当前数组的长度大于64时
 *              此时索引位置上的所有数据改为使用红黑树存储
 *
 *
 *
 *
 *
 *
 *
 *
 * @author rieson
 * @create 2021-01-11-17:57
 */
public class MapTest {
    @Test
    public void test3(){
        Map map = new HashMap<>();
        map.put("aa",123);
        map.put(123,456);
        map.put("AA","bb");
        //遍历所有的key集：KeySet
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历所有的value：values()
        Collection values = map.values();
        for (Object o : values ){
            System.out.println(o);
        }
        //遍历所有的key-value
        Set set1 = map.entrySet();
        Object a=new Object();
        System.out.println("------------------");


        for (Object o:set1){
            System.out.println(o);
        }
        System.out.println("****************");
        //方式一
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            Map.Entry m = (Map.Entry) next;
            System.out.println(m.getKey()+"------->"+m.getValue());
            System.out.println("+++++++++++++++++++++++");
            //System.out.println(iterator1.next());
        }
        //方式二
        Set set2 = map.keySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            Object key = iterator2.next();
            Object o = map.get(key);
            System.out.println(key+"======="+o);
        }

    }
    @Test
    public void test2(){

        Map map = new HashMap<>();
        //put(key,value):添加数据
        map.put("aa",123);
        map.put(123,456);
        map.put("AA","bb");
        System.out.println(map);
        //putAll（Map m）:将m集合的数据添加到map中
        HashMap m  = new HashMap<>();
        m.put(000,111);
        map.putAll(m);
        System.out.println(map);

        //remove(123):删除指定key值的key-value
        Object remove = map.remove(123);
        System.out.println(remove);
        System.out.println(map);
        //map.clear():清空集合中的元素
        map.clear();
        //map.get(111):获取指定key的value值
        map.get(000);
        // map.isEmpty():Map是否为空
        map.isEmpty();
        //map.containsKey(000);是否包含key值
        map.containsKey(000);
        //map.containsKey(000);是否包含制定的value
        map.containsValue(111);

    }
    @Test
    public void test1(){
        Map map = new HashMap<>();
        map.put(null,null);

    }
}
