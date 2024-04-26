package kr.co.programmers.school.solved.beginner;

public class Solution_120849 {
	// 모음 제거
	// https://school.programmers.co.kr/learn/courses/30/lessons/120849
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "bus";
		sol.solution(input);
	}

	static class Solution {
		public String solution(String my_string) {
			String[] arr = {"a", "e", "i", "o", "u"};
			for (int i = 0; i < 5; i++) {
				my_string = my_string.replace(arr[i], "");
			}

			System.out.println(my_string);
			return my_string;
		}

	}

}
