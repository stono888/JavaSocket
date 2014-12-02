package com.srie.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，服务器端
 * 
 * @author ThinkPad
 *
 */
public class Server {

	public static void main(String[] args) {
		try {
			// 1，创建serverSocket，指定端口，并进行监听
			ServerSocket serverSocket = new ServerSocket(8888);
			// 2,调用accept()方法，开始监听
			System.out.println("***服务器即将启动，等待客户端连接***");
			Socket socket = serverSocket.accept();
			// 3，获取输入流，读取客户端发送的信息
			InputStream is = socket.getInputStream();// 字节流
			InputStreamReader isr = new InputStreamReader(is);// 字符流
			BufferedReader br = new BufferedReader(isr);// 为输入流添加缓冲
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端说：" + info);
			}
			socket.shutdownInput();
			// 4,关闭资源
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
