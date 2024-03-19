package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_10872 {
    private static final Scanner sc = new Scanner(System.in);

    // 팩토리얼 - B3
    // https://www.acmicpc.net/problem/10872
    public static void main(String[] args) {
        int n = readInt();

        System.out.println(pacto(n));
    }

    public static long pacto(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * pacto(n - 1);
    }


    // Libraries
    private static int readInt() {
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

}

