package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_2446 {
    // 별 찍기 - 9
    // https://www.acmicpc.net/problem/2446
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        for (int i = -input + 1; i <= input - 1; i++) {
            int j = i;
            if (j < 0) {
                j = -i;
            }
            for (int l = 0; l < input - j - 1; l++) {
                System.out.print(" ");
            }
            for (int l = 0; l <= 2 * j; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}

