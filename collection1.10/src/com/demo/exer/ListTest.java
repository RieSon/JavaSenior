package com.demo.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author rieson
 * @create 2021-01-11-17:29
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(2);
        objects.add(2);
        objects.add(3);
        objects.add(3);
        ArrayList<Object> objects1 = unList(objects);

        Iterator<Object> iterator = objects1.iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }
    }
    public ArrayList<Object> unList(ArrayList list){
        HashSet<Object> objects = new HashSet<>();
        objects.addAll(list);
        return new ArrayList<>(objects);

    }
}
