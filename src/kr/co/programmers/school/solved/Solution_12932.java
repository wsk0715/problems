package kr.co.programmers.school.solved;

public class Solution_12932 {
	// 자연수 뒤집어 배열로 만들기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12932
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(long n) {
			String s = String.valueOf(n);
			int[] arr = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				arr[arr.length - 1 - i] = s.charAt(i) - 48;
			}
			return arr;
		}

	}

}
