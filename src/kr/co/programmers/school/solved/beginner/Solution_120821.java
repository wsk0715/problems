package kr.co.programmers.school.solved.beginner;

public class Solution_120821 {
	// 배열 뒤집기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120821
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5};
		solution(input);
	}

	public static int[] solution(int[] num_list) {
		int[] result = new int[num_list.length];

		for (int i = 0; i < num_list.length; i++) {
			result[i] = num_list[num_list.length - 1 - i];
		}

		return result;
	}

}
