package kr.co.programmers.school.solved.beginner;

public class Solution_120822 {
	// 문자열 뒤집기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120822
	public static void main(String[] args) {
		String input = "jaron";
		solution(input);
	}

	public static String solution(String my_string) {
		StringBuilder result = new StringBuilder();

		for (int i = my_string.length() - 1; i >= 0; i--) {
			result.append(my_string.charAt(i));
		}

		return result.toString();
	}

}
