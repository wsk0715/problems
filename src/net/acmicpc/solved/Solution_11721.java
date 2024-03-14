package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_11721 {
    // 열 개씩 끊어 출력하기
    // https://www.acmicpc.net/problem/11721
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            System.out.print(input.charAt(i));
            if ((i != 0) && (i % 10 == 9)) {
                System.out.println();
            }
        }
    }

}

