package com.srie.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		/**
		 * 向服务器端发送数据
		 */
		// 1,定义服务器地址；
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "用户名:tom;密码:123".getBytes();
		// 2,创建数据包，包含相关的信息；
		DatagramPacket packet = new DatagramPacket(data, data.length, address,
				port);
		// 3,创建DatagramSocket对象；
		DatagramSocket socket = new DatagramSocket();
		// 4,向服务器端发送数据报；
		socket.send(packet);
		/**
		 * 接收服务器端响应
		 */
		// 1，创建数据包，接收服务器端数据
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		// 2,接收服务器端数据
		socket.receive(packet2);
		// 3,读取数据
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("我是客户端，服务器说：" + reply);
		// 4,关闭资源
		socket.close();
	}

}
