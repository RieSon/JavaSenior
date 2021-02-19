package com.demo.exer;

/**
 * @author rieson
 * @create 2021-01-11-16:27
 */
public class MyDate implements Comparable{
    private String name;
    private int age;
    private Employee birthday;

    public MyDate() {
    }

    public MyDate(String name, int age, Employee birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public Employee getBirthday() {
        return birthday;
    }

    public void setBirthday(Employee birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate){
            MyDate md = (MyDate) o;

            return this.name.compareTo(md.name);
        }
        throw new RuntimeException("传入的参数不合法");
    }
}
