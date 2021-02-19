package com.demo.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author rieson
 * @create 2021-01-12-11:57
 */
public class TreeMapTest {
    //向TreeMap中添加的key-value，要求必须是同一类的创建的对象
    //应为要按照key进行排序：自然排序，定制排序
    public void test1() {
        Map map = new TreeMap();
        map.put("aa", 123);
        map.put(123, 456);
        map.put("AA", "bb");
    }
}

