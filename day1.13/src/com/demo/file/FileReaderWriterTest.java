package com.demo.file;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 一，流的分类：
 * 1，操作数据单位的：字节流，字符流
 * 2，数据的流向：输入流，输出流
 * 3，流的角色：节点流，处理流
 * 二。流的体系结构
 * 抽象基类              节点流（或文件流）              缓冲流（处理流的一种）
 * InputStream          FileInputStream             BufferedInputStream
 * OutputStream         FileOutputStream            BufferedOutputStream
 * Reader               FileReader                  BufferedReader
 * Writer               FileWriter                  BufferedWriter
 * @author rieson
 * @create 2021-01-14-10:48
 */
public class FileReaderWriterTest {

    @Test
    public void test1() throws IOException {
        //实例化File对象，指名要操作的文件
        File file = new File("1.txt");
        //2提供具体的流
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //3.数据的读入
        //read():返回读入的一个字符。如果达到末尾返回-1
        int read = fileReader.read();
        while (read != -1) {
            System.out.print((char) read);
            read = fileReader.read();



        }//4,流的关闭操作
        fileReader.close();
    }
}
