package net.acmicpc.solved;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_14659 {
    // 한조서열정리하고옴ㅋㅋ - B1
    // https://www.acmicpc.net/problem/14659
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] heights = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (heights[i] < heights[j]) {
                    break;
                }
                if (heights[i] > heights[j]) {
                    count += 1;
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

}

