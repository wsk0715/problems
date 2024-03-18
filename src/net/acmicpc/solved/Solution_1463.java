package net.acmicpc.solved;

import java.util.Scanner;

public class Solution_1463 {
    // 1로 만들기 - S3
    // https://www.acmicpc.net/problem/1463
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        System.out.println(sol(number));
    }

    private static int sol(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
        }
        return dp[n];
    }

}

// Greedy와 DP의 다른점?
// Greedy는 앞에서 한 선택이 뒤에서 할 수 있는 선택에 영향을 미치지 않는다.
// -> 최적의 해를 찾기 위한 방법이 정해져 있다.
// DP는 앞에서 한 선택이 뒤에서 영향을 미칠 수 있다.
// -> 모든 경우의 수를 탐색하며 최적의 해를 찾아야 함.
//    그러나 모든 경우를 전부 탐색하려면 시간이 오래 걸리기 때문에,
//    점화식을 도출해 내는 것이 중요하다.
