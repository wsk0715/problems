package net.acmicpc.solved.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1978 {
    private final static Scanner sc = new Scanner(System.in);

    // 소수 찾기 - B2
    // https://www.acmicpc.net/problem/1978
    public static void main(String[] args) {
        int n = readInt();

        int[] numbers = readInt(n);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrimeNumber(numbers[i])) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPrimeNumber(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i < n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Libraries

    private static int readInt() {
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    private static int[] readInt(int n) {
        return Arrays.stream(sc.nextLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}

