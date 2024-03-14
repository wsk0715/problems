package kr.co.programmers.school.solved;

public class Solution_120817 {
    // 배열의 평균값
    // https://school.programmers.co.kr/learn/courses/30/lessons/120817
    public double solution(int[] numbers) {
        double answer = 0;

        for (double n : numbers) {
            answer += n;
        }
        answer /= numbers.length;

        return answer;
    }

}
