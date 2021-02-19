package com.demo.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author rieson
 * @create 2021-01-11-16:29
 */
public class TreeSetTest  {
    //定制排序:按照生日日期排序
    @Test
    public void test2(){
        MyDate myDate5 = new MyDate("gasd",15,new Employee(1966,3,23));
        MyDate myDate1 = new MyDate("aasd",115,new Employee(1976,2,21));
        MyDate myDate2 = new MyDate("dasd",1115,new Employee(1986,11,31));
        MyDate myDate3 = new MyDate("easd",1335,new Employee(1996,5,6));
        MyDate myDate4 = new MyDate("gsasd",135,new Employee(1996,5,3));
        TreeSet<Object> set1 = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof MyDate && o2 instanceof MyDate) {
                    MyDate md1 = (MyDate) o1;
                    MyDate md2 = (MyDate) o2;
                    Employee b1 = md1.getBirthday();
                    Employee b2 = md2.getBirthday();

                    int minusYear = b1.getYear() - b2.getYear();
                    if (minusYear != 0) {
                        return minusYear;
                    }
                    int minusMonth = b1.getMonth() - b2.getMonth();
                    if (minusMonth != 0 ) {
                        return minusMonth;
                    }
                    int minusDay = b1.getDay() - b2.getDay();
                        return minusDay;

                }
                 throw new RuntimeException("传入数据类型不一致");
            }

        });
        set1.add(myDate5);
        set1.add(myDate1);
        set1.add(myDate3);
        set1.add(myDate2);
        set1.add(myDate4);
        Iterator<Object> iterator = set1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
//    //自然排序
//    @Test
//    public void test1(){
//        MyDate myDate5 = new MyDate("gasd",15,new Employee(1966,3,23));
//        MyDate myDate1 = new MyDate("aasd",115,new Employee(1976,2,21));
//        MyDate myDate2 = new MyDate("dasd",1115,new Employee(1986,11,31));
//        MyDate myDate3 = new MyDate("easd",1335,new Employee(1996,5,6));
//        MyDate myDate4 = new MyDate("gsasd",135,new Employee(1996,5,3));
//        TreeSet<Object> set = new TreeSet<>();
//        set.add(myDate5);
//        set.add(myDate1);
//        set.add(myDate3);
//        set.add(myDate2);
//        set.add(myDate4);
//        Iterator<Object> iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//    }


}
