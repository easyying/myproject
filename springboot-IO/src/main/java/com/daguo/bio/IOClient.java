package com.daguo.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author
 * BIO客户端
 * 场景：客户端每隔两秒发送一个带有时间戳的"hello world"给服务端，服务端收到之后打印
 */
public class IOClient {
    public static void main(String[] args) {
        //创建多个线程，模拟多个客户端连接服务端
        //匿名内部类创建线程 lambda表达式
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1",8000);
                while (true){
                    try {
                       socket.getOutputStream().write((new Date() + "hello world").getBytes());
                       socket.getOutputStream().flush();
                       Thread.sleep(2000);//连接上服务端8000端口之后，每隔2秒，我们向服务端写一个带有时间戳的 "hello world"
                    }catch (Exception e){

                    }
                }
            }catch (IOException e){

            }
        }).start();
    }
}
