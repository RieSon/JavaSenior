package com.demo.test;

import org.junit.Test;

/**
 * @author rieson
 * @create 2021-01-13-11:16
 */
public class GenericTest1 {
    @Test
    public void test1(){
        Order order = new Order();
        //order.setOrderT("123");
        Order<Integer> objectOrder = new Order<Integer>("asd",123,123);
        //objectOrder.setOrderT(123);
        System.out.println(objectOrder);
    }

}
