package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_10162 {
    // 전자레인지 - B3
    // https://www.acmicpc.net/problem/10162
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int goal = Integer.parseInt(sc.nextLine());

        System.out.println(sol(goal));
    }

    private static String sol(int goal) {
        if (goal % 10 != 0) {
            return "-1";
        }

        int[] times = {300, 60, 10};
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < times.length; i++) {
            if (str.length() > 0) {
                str.append(" ");
            }
            str.append(goal / times[i]);
            goal %= times[i];
        }
        return str.toString();
    }

}

