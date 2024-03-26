package kr.co.programmers.school.solved;

public class Solution_120824 {
	// 짝수 홀수 개수
	// https://school.programmers.co.kr/learn/courses/30/lessons/120824
	public static void main(String[] args) {
		int[] input = {};
		solution(input);
	}

	public static int[] solution(int[] num_list) {
		int nOdd = 0;
		int nEven = 0;

		for (int i = 0; i < num_list.length; i++) {
			if (num_list[i] % 2 == 0) {
				nEven += 1;
			} else {
				nOdd += 1;
			}
		}

		return new int[]{nEven, nOdd};
	}

}
