package com.srie.test;

import java.io.IOException;
import java.net.InetAddress;
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
			// 创建serverSocket，指定端口，并进行监听
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			// 记录客户端的数量
			int count = 0;
			System.out.println("***服务器即将启动，等待客户端连接***");
			// 循环监听客户端的连接
			while (true) {
				// 调用accept()方法，开始监听
				socket = serverSocket.accept();
				// 创建一个线程，与之通信
				ServerThread serverThread = new ServerThread(socket);
				serverThread.setPriority(4);// 设置线程优先级，范围[1，10]，默认为5
				// 启动线程
				serverThread.start();
				count++;
				System.out.println("客户端连接数：" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端Ip：" + address.getHostAddress());
			}
			// serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
