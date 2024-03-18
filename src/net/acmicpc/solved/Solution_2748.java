package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_2748 {
    // 피보나치 수 2 - B1
    // https://www.acmicpc.net/problem/2748
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sol(n));
    }

    public static long sol(int n) {
        long[] pibo = new long[91];
        pibo[1] = 1;
        for (int i = 2; i < pibo.length; i++) {
            pibo[i] = pibo[i - 1] + pibo[i - 2];
        }
        return pibo[n];
    }

}

