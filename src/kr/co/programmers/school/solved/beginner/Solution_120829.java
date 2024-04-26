package kr.co.programmers.school.solved.beginner;

public class Solution_120829 {
	// 각도기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120829
	public static void main(String[] args) {
		int input = 91;
		solution(input);
	}

	public static int solution(int angle) {
		return (0 < angle && angle < 90) ? 1 : (90 == angle) ? 2 : (90 < angle && angle < 180) ? 3 : 4;
	}

}
