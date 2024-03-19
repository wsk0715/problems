package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_8958 {
    // OX퀴즈 - B2
    // https://www.acmicpc.net/problem/8958
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            int score = 0;
            int streak = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'O') {
                    score += ++streak;
                }
                if (input.charAt(j) == 'X') {
                    streak = 0;
                }
            }
            System.out.println(score);
        }
    }

}

