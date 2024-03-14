package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_1924 {
    // 2007년
    // https://www.acmicpc.net/problem/1924
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        System.out.println(getDayOfWeek(x, y));
    }

    public static String getDayOfWeek(int x, int y) {
        int[] dateOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int inputDate = y;
        for (int i = 1; i < x; i++) {
            inputDate += dateOfMonth[i - 1];
        }

        switch (inputDate % 7) {
            case 0:
                return "SUN";
            case 1:
                return "MON";
            case 2:
                return "TUE";
            case 3:
                return "WED";
            case 4:
                return "THU";
            case 5:
                return "FRI";
            case 6:
                return "SAT";
            default:
                return "";
        }
    }

}

