package kr.co.programmers.school.solved.acceptance;

public class _Solution_181836 {
	// 그림 확대
	// https://school.programmers.co.kr/learn/courses/30/lessons/181836
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String[] picture, int k) {
			String[] r = new String[picture.length * k];
			for (int i = 0; i < picture.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < picture[i].length(); j++) {
					sb.append(repeat(String.valueOf(picture[i].charAt(j)), k));
				}
				picture[i] = sb.toString();
			}
			for (int i = 0; i < r.length; i++) {
				r[i] = picture[i / k];
			}
			return r;
		}

	}

	public static String repeat(String str, int count) {
		if (count <= 0) return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(str);
		}
		return sb.toString();
	}

}
