package com.liyc.algs.pata;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * array[指数] = 系数
 * 1. 系数相加为0时总数减1
 * 2. 系数可能为负数，固最后不能as[i]>0
 */
public class A1034 {
	private static int[][] g;
	private static int[] v;
	private static int threthold;
	private static int maxpersons = 90;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line1 = in.nextLine();

		String[] line1as = line1.split(" ");
		int totalcalls = Integer.valueOf(line1as[0]);
		threthold = Integer.valueOf(line1as[1]);

//		maxpersons = totalcalls * 2;

		g = new int[maxpersons][maxpersons];
		v = new int[maxpersons];
		int[] w = new int[maxpersons];
		Map<Integer, List<Integer>> subg = new HashMap<>();
		Map<Integer, Integer> maxtime = new HashMap<>();

		for (int k = 0; k < totalcalls; k++) {
			String[] lines = in.nextLine().split(" ");
//			System.out.println(Arrays.asList(lines));
			int i = lines[0].charAt(0);
			int j = lines[1].charAt(0);
			int time = Integer.valueOf(lines[2]);
			if(g[j][i] > 0){
				g[j][i] = g[j][i] + time;
			}else {
				g[i][j] = time;
			}
			w[j] = w[j] + time;
			w[i] = w[i] + time;
		}

		for (int i = 0; i < maxpersons; i++) {
			if( w[i] == 0 || v[i] > 0){
				continue;
			}
//			System.out.println("i = "+i+", "+String.valueOf((char)i));
			List<Integer> list = new ArrayList<>(maxpersons);
			list.add(0);
//			list.add(i);
			subg.put(i, list);
			dfs(i, list);
		}
		AtomicInteger count = new AtomicInteger();
		Map<Integer, Integer> ps = new TreeMap<>();
		subg.forEach((k, list)->{
//			System.out.print((char)k.intValue()+" : ");
//			for (int i = 1; i < list.size(); i++) {
//				System.out.print((char)list.get(i).intValue());
//			}
//			System.out.print(" size = "+list.size()+" maxtime="+list.get(0));
//			System.out.println();
			if(list.size() <= 3){
				return;
			}
			if(list.get(0) <= threthold ){
				return;
			}
			count.getAndIncrement();
			int max = list.get(1);
			for (int i = 2; i < list.size(); i++) {
				if(w[list.get(i)] > w[max]){
					max = list.get(i);
				}
			}
			ps.put(max, list.size()-1);
		});
		System.out.println(count);
		if(count.intValue()==0){
			return;
		}
		ps.forEach((k, v)->{
			String name = String.valueOf((char)k.intValue());
			name = name+name+name;
			System.out.println(name+" "+ps.get(k));
		});
	}

	private static void dfs(int i, List<Integer> list) {
		v[i] = 1;
		list.add(i);
//		System.out.println(i+" "+(char)i);
		for (int j = 0; j < maxpersons; j++) {
			if(g[i][j] == 0){
				continue;
			}
			list.set(0, list.get(0)+g[i][j]);
			if(v[j] > 0) {
				continue;
			}
			dfs(j, list);
		}
	}
}
