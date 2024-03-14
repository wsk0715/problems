package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_2441 {
    // 별 찍기 - 4
    // https://www.acmicpc.net/problem/2441
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        for (int i = 0; i < input; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = input - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
