package com.atguigu.team.view;

import java.util.Scanner;

import org.junit.Test;

/**
 * 项目中提供了TSUyility.java类，可用来方便的实现键盘的访问
 * @author Administrator
 *
 */
public class TSUyility {
	private static Scanner scanner = new Scanner(System.in);
	/**
	 * 该方法读取肩旁，如果用户键入‘1’-‘4’中的任意字符，则方法返回，返回值为用户输入的数值
	 * 
	 */
	@Test
	public static char readMenuSelection() {
		char c;
		for(;;) {
			String str = readKeyBoard(1,false);
			c=str.charAt(0);
			if(c!='1'&& c!='2'&&c!='3'&&c!='4') {
				System.err.println("输入错误！请重新输入:");
			}else break;
				
			
		}
		return c;
		
	}
	/**
	 * 该方法提示并被等待，指导用户按回车键后返回
	 */
	public static void readReturn() {
		System.err.println("按回车键继续。。。。。");
		readKeyBoard(100,true);
	}
	
	public static int readInt() {
		int n;
		for(;;) {
			String str = readKeyBoard(2,false);
			n=Integer.parseInt(str);
			break;
		}
		return n;
		
	}
	/**
	 * 从键盘读取‘Y’，‘N’，并将其作为方法的返回值
	 * 
	 * @return
	 */
	public static char readConfirmSelection() {
		char c;
		for(;;) {
			String str = readKeyBoard(1,false).toUpperCase();
			c = str.charAt(0);
			if(c== 'Y'||c=='N') {
				break;
			}else {
				System.err.println("选择错误，请重新输入：");
			}
			
		}
		return c;
	}
	
	private static String readKeyBoard(int i, boolean b) {
		String line="";
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.length()==0){
				if(b) return line;
				else continue;
			}
			if(line.length()<1||line.length()>i) {
				System.err.println("输入长度（不大于"+i+")错误，请重新输入：");
				continue;
			}
			break;
		}
		return line;
	}
}
