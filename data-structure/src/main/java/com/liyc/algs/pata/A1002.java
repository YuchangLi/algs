package com.liyc.algs.pata;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Hello world!
 */
public class A1002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k1 = in.nextInt();
        Map<Integer, Double> map = new TreeMap<>(Comparator.comparingDouble(ko -> -ko));

        for (int i = 0; i < k1; i++) {
            Integer key = in.nextInt();
            double value = in.nextDouble();
            map.put(key, value);
        }
        int k2 = in.nextInt();
        for (int i = 0; i < k2; i++) {
            Integer key = in.nextInt();
            double value = in.nextDouble();
            if(map.containsKey(key)){
                map.put(key, map.get(key)+value);
            }else{
                map.put(key, value);
            }
        }
        System.out.print(map.size());
        map.forEach((k, v)->{
            System.out.print(" "+k+" "+String.format("%.1f", v));
        });
    }
}
