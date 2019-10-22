package com.liyc.algs.pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 */
public class A1003 {
	// 顶点数
	private static int num;
	// 图
	private static int[][] g;
	// 顶点是否已访问
	private static boolean[] v;
	// 顶点s到各顶点的路径
	private static int[] d;
	// 各顶点人数
	private static int[] p;
	// 顶点s到各顶点的路径累计人数
	private static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line1 = bf.readLine();
		String[] lineas1 = line1.split(" ");
		num = Integer.valueOf(lineas1[0]);
		int roads = Integer.valueOf(lineas1[1]);
		int source = Integer.valueOf(lineas1[2]);
		int destination = Integer.valueOf(lineas1[3]);
		String line2 = bf.readLine();
		String[] lineas2 = line2.split(" ");
		// 初始化各顶点人数
		for (int i = 0; i < num; i++) {
			p[i] = Integer.valueOf(lineas2[i]);
		}
		// 初始化顶点s到各顶点的路径累计人数
		sum = new int[num];
		sum[source] = p[source];
		// 初始化图
		g = new int[num][num];
		while (roads-- > 0) {
			String line = bf.readLine();
			String[] lineas = line.split(" ");
			int i = Integer.valueOf(lineas[0]);
			int j = Integer.valueOf(lineas[1]);
			int length = Integer.valueOf(lineas[2]);
			g[i][j] = length;
			g[j][i] = length;
		}
		// 初始化顶点source到各顶点的路径
		d = new int[num];
		for (int i = 0; i < num; i++) {
			if (i == source) {
				d[i] = 0;
			} else {
				d[i] = 1000000000;
			}
		}

		// Dijsktra
		while (num-- > 0) {
			int u = minAndNotVisited(d, v);
		}

	}

	// 获取未访问过且离source最近的顶点u
	private static int minAndNotVisited(int[] d, boolean[] v) {
		int u = -1;
		for (int i = 0; i < num; i++) {
			if (u == -1 || (d[i] < d[u] && !v[i])) {
				u = i;
			}
		}
		return u;
	}
}
