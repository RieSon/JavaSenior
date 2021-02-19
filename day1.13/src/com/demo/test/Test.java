package com.demo.test;

import java.lang.reflect.Field;

/**
 * @author rieson
 * @create 2021-01-16-10:06
 */
public class Test {
    @org.junit.Test
    public void test1() throws Exception {
        Class orderClass = Order.class;

        //newInstance()调用此方法，创建对应的运行时类的对象
        //要想此方式创建对应的运行时类的对象，运行时类必须有空参的构造器
        //访问修饰符通常设置为public

        Object o = orderClass.newInstance();
        Field name = orderClass.getDeclaredField("name");

        System.out.println(o);


    }
}
