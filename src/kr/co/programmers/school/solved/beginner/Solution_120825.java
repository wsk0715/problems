package kr.co.programmers.school.solved.beginner;

public class Solution_120825 {
	// 문자 반복 출력하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120825
	public static void main(String[] args) {
		solution("hello", 3);
	}

	public static String solution(String my_string, int n) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < my_string.length(); i++) {
			for (int j = 0; j < n; j++) {
				sb.append(my_string.charAt(i));
			}
		}

		return sb.toString();
	}

}
