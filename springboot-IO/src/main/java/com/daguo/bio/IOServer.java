package com.daguo.bio;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author
 * 服务端
 */
public class IOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        //1) 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理 接受新的连接线程
        new Thread(() ->{
            while (true){
                try {
                   // 2) 阻塞方法获取新的连接
                   Socket socket = serverSocket.accept();
                   //3) 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(()->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();//获取字节输入流
                            //4) 按字节流方式读取数据
                            while ((len =inputStream.read(data)) != -1){
                                System.out.println(new String(data,0,len));
                            }
                        }catch (IOException e){

                        }
                    }).start();

                }catch (Exception e){

                }
            }

        }).start();

    }
}
