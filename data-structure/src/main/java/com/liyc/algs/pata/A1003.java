package com.liyc.algs.pata;

import java.util.Scanner;

/**
 * array[指数] = 系数
 * 1. 系数相加为0时总数减1
 * 2. 系数可能为负数，固最后不能as[i]>0
 */
public class A1003 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(str);
		String str2 = in.nextLine();
		System.out.println(str2);
		System.out.println(str2.split(" ")[4]);
	}
}
