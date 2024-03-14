package kr.co.programmers.school.solved;

public class Solution_120815 {
    // 피자 나눠 먹기 (2)
    // https://school.programmers.co.kr/learn/courses/30/lessons/120815
    public int solution(int n) {
        int PIZZA_PIECE = 6;
        int answer = 0;

        int goal = PIZZA_PIECE * n / getGcd(PIZZA_PIECE, n);
        int i = 0;

        while (true) {
            i++;
            if (i % goal == 0) {
                answer = i / PIZZA_PIECE;
                break;
            }
        }

        return answer;
    }

    public int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

}
