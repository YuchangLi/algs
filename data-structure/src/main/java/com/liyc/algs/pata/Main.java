package com.liyc.algs.pata;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k1 = in.nextInt();
        double[] as = new double[1005];
        int count = k1;
        for (int i = 0; i < k1; i++) {
            Integer key = in.nextInt();
            double value = in.nextDouble();
            as[key] = value;
        }
        int k2 = in.nextInt();
        for (int i = 0; i < k2; i++) {
            Integer key = in.nextInt();
            double value = in.nextDouble();
            if(as[key]==0){
                count++;
            }
            as[key] = as[key]+value;
        }
        System.out.print(count);
        for (int i = as.length-1; i >=0 ; i--) {
            if(as[i]>0){
                System.out.print(" "+i+" "+String.format("%.1f", as[i]));
            }
        }
    }
}
