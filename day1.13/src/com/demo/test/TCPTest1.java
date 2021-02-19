package com.demo.test;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author rieson
 * @create 2021-01-15-10:15
 */
public class TCPTest1 {
    //客户端
    @Test
    public void client(){
        OutputStream outputStream=null;
        Socket socket=null;
        try {
            InetAddress byName = InetAddress.getByName("127.0.0.1");

             socket = new Socket(byName,8899);
             outputStream = socket.getOutputStream();
            outputStream.write("你好，我是客户端".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    //服务端
    @Test
    public void server()  {
        ServerSocket serverSocket =null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            serverSocket = new ServerSocket(8899);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            //不建议这样写
      /*  byte[] bytes = new byte[200];
        int len;
        while ((len=inputStream.read(bytes))!=-1){

        }*/
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
        byteArrayOutputStream.write(bytes,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("收到了来自"+accept.getInetAddress().getHostAddress()+"的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (byteArrayOutputStream!=null)
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream!=null)
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (accept!=null)
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket!=null)
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
