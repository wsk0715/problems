package net.acmicpc.solving;

import java.util.Arrays;
import java.util.Scanner;

public class $Solution_ {
    private static final Scanner sc = new Scanner(System.in);

    //
    // https://www.acmicpc.net/problem/
    public static void main(String[] args) {
        int n = readInt();

    }


    // Libraries
    private static String readLine() {
        return sc.nextLine();
    }

    private static int readInt() {
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    private static int[] readIntFrom(int n) {
        for (int i = 1; i < n; i++) {
            sc.nextInt();
        }
        return Arrays.stream(sc.nextLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
