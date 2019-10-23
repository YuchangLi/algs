package com.liyc.algs.pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Dijkstra求source 到各顶点的最短距离/条数/累计人数最多（点权）
 */
public class A1003 {
	// 顶点数
	private static int num;
	// 图
	private static int[][] g;
	// 顶点是否已访问
	private static boolean[] v;
	// 顶点s到各顶点的最短路径长度
	private static int[] d;
	// 顶点s到各顶点的最短路的条数
	private static int[] count;
	// 各顶点人数
	private static int[] p;
	// 顶点s到各顶点的路径累计人数
	private static int[] sum;
	// 顶点s到各顶点的最短路径初始值（极大值）
	private static int INF = 1_000_000_000;

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
		p = new int[num];
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
		bf.close();
		// 初始化顶点source到各顶点的路径
		d = new int[num];
		count = new int[num];
		for (int i = 0; i < num; i++) {
			if (i == source) {
				d[i] = 0;
				count[i] = 1;
			} else {
				d[i] = INF;
			}
		}
		v = new boolean[num];
		// Dijsktra
		int nums = num;
		while (nums-- > 0) {
			int u = minAndNotVisited(d, v);
			if (u == -1){
				break;
			}
			v[u] = true;
			// 更新从source出发经u到u相连的顶点v的距离/最短路径条数/累计人数
			for (int j = 0; j < num; j++) {
				if (g[u][j] > 0 && !v[j]) {
					if(d[u] + g[u][j] < d[j]) {
						d[j] = d[u] + g[u][j];
						count[j] = count[u];
						sum[j] = sum[u] + p[j];
					} else if (d[u] + g[u][j] == d[j]) {
						count[j] = count[u] + count[j];
						if((sum[u] + p[j])>sum[j]) {
							sum[j] = sum[u] + p[j];
						}
					}
				}
			}
		}
		System.out.print(count[destination]+" "+sum[destination]);

	}

	/**
	 * 获取未访问过且离source最近的顶点u,返回-1说明找不到和source相连接的且未访问过的顶点
	 */
	private static int minAndNotVisited(int[] d, boolean[] v) {
		int u = -1; int min = INF;
		for (int i = 0; i < num; i++) {
			if (d[i] < min && !v[i]) {
				u = i;
				min = d[i];
			}
		}
		return u;
	}
}
