package com.liyc.algs.pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 构建Map<index, name>, 构建g[name1][name2]
 */
public class A1034 {
	private static int[][] g;
	private static int[] v;
	private static int[] w;
	private static int threthold;
	private static int personsN;
	public static void main(String[] args) throws IOException {
//		long s = System.currentTimeMillis();
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line1 = bf.readLine();
		String[] line1as = line1.split(" ");
		int totalcalls = Integer.valueOf(line1as[0]);
		threthold = Integer.valueOf(line1as[1]);
		int maxpersons = totalcalls * 2;
		int index = 0;
		Map<Integer, String> persons = new HashMap<>(maxpersons);
		g = new int[maxpersons][maxpersons];
		v = new int[maxpersons];
		w = new int[maxpersons];

		for (int k = 0; k < totalcalls; k++) {
			String[] lines = bf.readLine().split(" ");
			String name1 = lines[0];
			String name2 = lines[1];
			int i = 0;
			if(!persons.containsValue(name1)){
				i = index++;
				persons.put(i, name1);
			} else{
				i = getKeyFromValue(persons, name1);
			}
			int j = 0;
			if(!persons.containsValue(name2)){
				j = index++;
				persons.put(j, name2);
			} else{
				j = getKeyFromValue(persons, name2);
			}
			int time = Integer.valueOf(lines[2]);
			g[i][j] += time;
			g[j][i] += time;
			w[j] = w[j] + time;
			w[i] = w[i] + time;
		}
		bf.close();
		personsN = persons.size();
		Set<Set<Integer>> subg = new HashSet<>();
		for (int i = 0; i < personsN; i++) {
			if( v[i] > 0){
				continue;
			}
			Set<Integer> set = new HashSet<>(maxpersons);
			subg.add(set);
			dfs(i, set);
		}
		int count = 0;
		Map<Integer, Integer> ps = new TreeMap<>(Comparator.comparing(persons::get));
		for (Set<Integer> set : subg){
			if(set.size() <= 2){
				continue;
			}
			int max = -1;
			int sum = 0;
			for (int i : set) {
				int iw = w[i];
				sum += iw;
				if (max == -1 || iw > w[max]) {
					max = i;
				}
			}
			if( sum /2 <= threthold) {
				continue;
			}
			count++;
			ps.put(max, set.size());
		}
		System.out.println(count);
		if(count==0){
//			System.out.println(System.currentTimeMillis()-s);
			return;
		}
		ps.forEach((k, v)->{
			String name = persons.get(k);
			System.out.println(name+" "+ps.get(k));
		});
//		System.out.println(System.currentTimeMillis()-s);
	}

	private static int getKeyFromValue(Map<Integer, String> persons, String name1) {
		Set<Map.Entry<Integer, String>> set =  persons.entrySet();
		for (Map.Entry<Integer, String> en : set) {
			if(en.getValue().equals(name1)) {
				return en.getKey();
			}
		}
		return 0;
	}

	private static void dfs(int i, Set<Integer> list) {
		v[i] = 1;
		list.add(i);
		for (int j = 0; j < personsN; j++) {
			if(g[i][j] == 0){
				continue;
			}
			if(v[j] > 0) {
				continue;
			}
			dfs(j, list);
		}
	}
}
