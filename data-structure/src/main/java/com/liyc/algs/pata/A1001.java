package com.liyc.algs.pata;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
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
