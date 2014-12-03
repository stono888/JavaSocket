package com.srie.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * TODO 1，多线程优先级 2，是否关闭输入输出流 3，使用TCP传递对象 4，使用TCP传递文件 5,UDP中多线程交互;
 * 服务器端，实现基于UDP的用户认证
 * 
 * @author ThinkPad
 *
 */
public class UDPServerSingle {

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
			socket.receive(packet);// 此方法在接收到数据包之前会一直阻塞；
			// 4，读取客户端数据
			String info = new String(data, 0, packet.getLength());
			System.out.println("我是服务器，客户端说：" + info);
			/**
			 * 向客户端响应数据
			 */
			// 1，定义客户端的地址、端口号、数据
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			byte[] data2 = "欢迎您！".getBytes();
			// 2，创建数据包，包含响应的数据信息；
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length,
					address, port);
			// 3,响应客户端
			socket.send(packet2);
			// 4,关闭相应的资源信息
			socket.close();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
