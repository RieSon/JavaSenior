package com.demo.colletion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author rieson
 * @create 2021-01-10-17:19
 */
public class ForEachTest {
    @Test
    public void test1(){
        Collection con = new ArrayList();
        //add(Object e):将元素e添加到集合con中
        con.add(1);
        con.add("asd");
        con.add(new Date());

        for(Object object:con){
            System.out.println(object);
        }
    }

}
