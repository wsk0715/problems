package kr.co.programmers.school.solved;

public class Solution_120814 {
    // 피자 나눠 먹기 (1)
    // https://school.programmers.co.kr/learn/courses/30/lessons/120814
    public int solution(int n) {
        int PIZZA_PIECE = 7;
        int answer = 0;
        int i = 0;

        while (true) {
            int pieces = PIZZA_PIECE * ++i;
            if (pieces / n >= 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

}
