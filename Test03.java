package com.srie.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用URL读取页面内容
 * 
 * @author ThinkPad
 *
 */
public class Test03 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://10.1.191.97");
			url = new URL("http://www.baidu.com");
			//获取字节输入流
			InputStream is = url.openStream();
			//将字节输入流转换为字符输入流
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//为流添加缓冲，提高读取效率
			BufferedReader bf = new BufferedReader(isr);
			//读取数据；
			String data = bf.readLine();
			while(data !=null){
				System.out.println(data);
				data = bf.readLine();
			}
			bf.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
