package com.liyc.algs.pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 构建Map<index, name>, 构建g[name1][name2]
 */
public class A1076 {
	// 图
	private static int[][] g;
	// 顶点是否已访问
	private static int[] v;
	// 顶点的level
	private static int[] levels;
	// 数字总长度
	private static int length;
	// 限制level
	private static int level;
	
	private static Queue<Integer> queue ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line1 = bf.readLine();
		String[] line1as = line1.split(" ");
		int persons = Integer.valueOf(line1as[0]);
		length = persons+1;
		level = Integer.valueOf(line1as[1]);
		// 构建图, 0不存
		g = new int[length][length];
		v = new int[length];
		levels = new int[length];
		queue = new LinkedBlockingQueue<>(persons);
		for (int i = 1; i <= persons; i++) {
			String line = bf.readLine();
			String[] lines = line.split(" ");
			if(Integer.valueOf(lines[0]) == 0) {
				continue;
			}
			for(int j = 1; j<lines.length; j++) {
				g[i][Integer.valueOf(lines[j])] = 1;
			}
		}
		String line = bf.readLine();
		String[] lines = line.split(" ");
		bf.close();
		for (int k = 1; k<lines.length; k++) {
			System.out.println(count(Integer.valueOf(lines[k])));
			for (int i = 1; i <= persons; i++) {
				v[i] = 0;
				levels[i] = 0;
			}
			queue.clear();
		}
	}
	private static int count(int k) {
		int sum = 0;
		queue.add(k);
		v[k] = 1;
		levels[k] = 0;
		while (!queue.isEmpty()) {
			int i = queue.poll();
			for (int j = 1; j<length; j++) {
				// 指向我且未访问
				if(g[j][i] != 0 && v[j]==0) {
					// 第level-1层时就不用再往queue里添加了
					if(levels[i]<level-1) {
						queue.add(j);
					}
					sum++;
					v[j] = 1;
					levels[j] = levels[i]+1;
				}
			}
		}
		return sum;
	}
}
