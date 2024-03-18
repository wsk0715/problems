package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_1157 {
    // 단어 공부 - B1
    // https://www.acmicpc.net/problem/1157
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input = input.toUpperCase();

        int[] counts = new int[26];
        for (int i = 0; i < input.length(); i++) {
            counts[input.charAt(i) - 65] += 1;
        }

        int max = 0, idx = 0;
        for (int i = 0; i < counts.length; i++) {
            if (max < counts[i]) {
                max = counts[i];
                idx = i;
            }
        }
        int maxCount = 0;
        for (int count : counts) {
            if (count == max) {
                maxCount++;
            }
        }

        System.out.println(maxCount > 1 ? "?" : (char) (idx + 65));
    }

}

