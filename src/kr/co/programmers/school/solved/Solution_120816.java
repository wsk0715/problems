package kr.co.programmers.school.solved;

public class Solution_120816 {
    // 피자 나눠 먹기 (3)
    // https://school.programmers.co.kr/learn/courses/30/lessons/120816
    public int solution(int slice, int n) {
        int i = 0;

        while (true) {
            int x = slice * ++i / n;
            if (x >= 1) {
                break;
            }
        }

        return i;
    }

}
