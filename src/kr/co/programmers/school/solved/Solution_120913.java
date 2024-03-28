package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_120913 {
	// 잘라서 배열로 저장하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120913
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String s, int n) {
			ArrayList<String> arr = new ArrayList<>();
			for (int i = 0; i < s.length() / n - 1; i++) {
				arr.add(s.substring(n * i, n + n * i));
			}
			arr.add(s.substring(s.length() - s.length() % n, s.length()));
			String[] result = new String[(s.length() % n == 0) ? s.length() / n : s.length() / n + 1];
			for (int i = 0; i < result.length; i++) {
				result[i] = arr.get(i);
			}
			return result;
		}

	}

}
