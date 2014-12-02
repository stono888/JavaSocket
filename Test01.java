package com.srie.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
/**
 * InetAddress
 * @author ThinkPad
 *
 */
public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
		byte[] bytes = address.getAddress();
		System.out.println(Arrays.toString(bytes));
		System.out.println(address);
		System.out.println("===================");

		// InetAddress address2 = InetAddress.getByName("Lenovo-PC");
		InetAddress address2 = InetAddress.getByName("10.1.207.34");
		System.out.println(address2.getHostName());
		System.out.println(address2.getHostAddress());
	}

}
