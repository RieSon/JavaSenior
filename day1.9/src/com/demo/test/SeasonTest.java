package com.demo.test;

/**
 * 一，枚举类的使用
 * 1，枚举类的理解：类的对象只有有限个，确定的，我们称此为枚举类
 * 2，当需要定义一组常量时，强烈建议使用枚举类
 * 3，如果枚举类中只有一个对象，则可以作为单例模式的实现方法
 * 二：如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 * 三：Enum类的常用方法
 * 1,values()返回枚举类型的对象数组，可以遍历查看当前枚举类的所有常量
 * 2，valuesOf(String objName):返回枚举类中对象名是objName对象,输入的对象没有找到就会抛异常
 * 3，toString()，返回当前枚举类对象常量的名称
 * 四，使用enum关键字定义的枚举类中实现接口的情况
 *  情况一：实现接口，在enum类中实现抽象方法
 *  情况二：让每个枚举类分别实现接口中抽象方法
 * @author rieson
 * @create 2021-01-09-15:53
 */

public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Seaseon1.SPRING.toString());
    }
}
//自定义枚举类
enum Seaseon1{
    //1，提供当前枚举类的多个对象：public static final的
      SPRING("春天","春暖花开"),
      SUMMER ("夏天","夏日炎炎"),
     AUTUMN ("秋天","秋高气爽"),
     WINTER("冬天","白雪皑皑");

    //2，声明Season对象的属性：private,final修饰
    private final String seasonName;
    private final String seasonDesc;
    //3,私有化类的构造器，并给对象属性赋值
    Seaseon1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //4获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //4，其他诉求1：提供toString()

/*    @Override
    public String toString() {
        return "Seaseon1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/
}