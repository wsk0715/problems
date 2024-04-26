package kr.co.programmers.school.solved.beginner;

public class Solution_120826 {
	// 특정 문자 제거하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120826
	public static void main(String[] args) {
		solution("abcdef", "f");
	}

	public static String solution(String my_string, String letter) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < my_string.length(); i++) {
			if (my_string.charAt(i) != letter.charAt(0)) {
				sb.append(my_string.charAt(i));
			}
		}

		return sb.toString();
	}

}
