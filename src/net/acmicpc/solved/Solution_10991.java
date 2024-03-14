package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_10991 {
    // 별 찍기 - 16
    // https://www.acmicpc.net/problem/10991
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= input - i; j++) {
                System.out.print(" ");
            }

            for (int n = 2 * i - 1; n > 0; n--) {
                if (n % 2 != 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}

