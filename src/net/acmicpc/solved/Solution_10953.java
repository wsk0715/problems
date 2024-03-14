package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_10953 {
    // A+B - 6
    // https://www.acmicpc.net/problem/10953
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int[] arr = getUserInput(sc);
            System.out.println(arr[0] + arr[1]);
        }
    }

    public static int[] getUserInput(Scanner sc) {
        String inputStr = sc.nextLine();
        String[] splitStr = inputStr.split(",");

        int[] arr = new int[2];
        arr[0] = Integer.parseInt(splitStr[0]);
        arr[1] = Integer.parseInt(splitStr[1]);

        return arr;
    }

}

