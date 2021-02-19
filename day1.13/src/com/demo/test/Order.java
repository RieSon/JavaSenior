package com.demo.test;

/**
 * @author rieson
 * @create 2021-01-13-11:17
 */
public class Order <T>{
    private String name;
    private int age;
    T orderT;

    public Order() {
    }

    public Order(String name, int age, T orderT) {
        this.name = name;
        this.age = age;
        this.orderT = orderT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", orderT=" + orderT +
                '}';
    }
}
