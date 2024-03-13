package kr.co.programmers.school;

public class Solution_120813 {
    // 짝수는 싫어요
    // https://school.programmers.co.kr/learn/courses/30/lessons/120813
    public int[] solution(int n) {
        int arrayLength = (n + 1) / 2;
        int[] answer = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            answer[i] = 2 * (i + 1) - 1;
        }

        return answer;
    }

}
