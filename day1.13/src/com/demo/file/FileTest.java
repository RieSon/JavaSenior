package com.demo.file;

import org.junit.Test;

import java.io.File;

/**
 *
 *
 *
 * @author rieson
 * @create 2021-01-13-17:41
 */
public class FileTest {
    /*
     一，创建File类的实例
         1，File（String filePath）：new File("1.txt");//相对路径
         2，File（String parentPath,String childPath）
         3,File（File parentPath,String childPath）
     */
    @Test
    public void test1(){

        //构造器一
        File file = new File("1.txt");//相对路径
        File file1 = new File("D:\\IdeaProjects\\JavaSenior\\day1.13");//绝对路径
        // System.out.println(file1);
        System.out.println(file);

        //构造器二
        File file2 = new File("D:\\IdeaProjects","JavaSenior");
        System.out.println(file2);
        //构造器三
        File file3 = new File(file2,"day1.13");
        System.out.println(file.getPath());
        System.out.println(file3);
        String[] list = file2.list();
        for (String s:list){
            System.out.println(s);
        }
        System.out.println("***********");
        File[] files = file2.listFiles();
        for (File file4:files){
            System.out.println(file4);
        }
    }
}
