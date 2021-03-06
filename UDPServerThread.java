package com.srie.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServerThread extends Thread {
	DatagramSocket socket = null;
	DatagramPacket packet = null;
	byte[] data = null;

	public UDPServerThread(DatagramSocket socket, DatagramPacket packet,
			byte[] data) {
		this.socket = socket;
		this.packet = packet;
		this.data = data;
	}

	@Override
	public void run() {
		try {
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
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
