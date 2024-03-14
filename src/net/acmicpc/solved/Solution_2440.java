package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_2440 {
    // 별 찍기 - 3
    // https://www.acmicpc.net/problem/2440
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        for (int i = input; i > 0; i--) {
            System.out.println("*".repeat(i));
        }
    }

}
