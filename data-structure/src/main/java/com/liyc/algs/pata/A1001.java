package com.liyc.algs.pata;

import java.io.IOException;
import java.util.Scanner;

/**
 * 1,000
 * 0123
 * 3210
 * 1,000,000
 * 0123456
 * 6543210
 * 规律：i对于的(length-1-i) % 3 == 0 且大于0
 */
public class A1001 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int sum = a + b;
        if(sum < 0 ){
            System.out.print("-");
            sum = -sum;
        }
        String[] ss = (sum+"").split("");
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i]);
            int index = ss.length-1-i;
            if(index >0 && index%3==0){
                System.out.print(",");
            }
        }
    }
}
