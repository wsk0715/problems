package kr.co.programmers.school.solved;

public class Solution_120819 {
	// 아이스 아메리카노
	// https://school.programmers.co.kr/learn/courses/30/lessons/120819
	public static void main(String[] args) {
		int input = 100_000;
		solution(input);
	}

	public static int[] solution(int money) {
		int[] result = new int[2];

		result[0] = money / 5_500;
		result[1] = money % 5_500;

		return result;
	}

}
