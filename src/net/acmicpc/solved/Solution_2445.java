package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_2445 {
    // 별 찍기 - 8
    // https://www.acmicpc.net/problem/2445
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        for (int i = 1; i <= input; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 2 * (input - i); j >= 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = input - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 2 * (input - i); j >= 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}

