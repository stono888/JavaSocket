package com.srie.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * TODO 1，多线程优先级 2，是否关闭输入输出流 3，使用TCP传递对象 4，使用TCP传递文件 5,UDP中多线程交互;
 * 服务器端，实现基于UDP的用户认证
 * 
 * @author ThinkPad
 *
 */
public class UDPServer {

	public static void main(String[] args) {
		try {

			/**
			 * 服务器端接收客户端的信息
			 */
			// 1，创建服务器端DatagramSocket，指定端口号
			DatagramSocket socket = new DatagramSocket(8800);
			// 2，创建数据包，存储客户端发送的数据；
			byte[] data = new byte[1024];// 创建字节数组，指定长度
			DatagramPacket packet = new DatagramPacket(data, data.length);
			// 3，接收客户端发送的数据；
			System.out.println("***服务器端已经启动，等待客户端发送数据***");
			int count = 0;
			while (true) {
				socket.receive(packet);// 此方法在接收到数据包之前会一直阻塞；
				UDPServerThread thread = new UDPServerThread(socket, packet,
						data);
				thread.start();
				count++;
				System.out.println("客户端连接数：" + count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
