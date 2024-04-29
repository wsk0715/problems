package kr.co.programmers.school.solved.lv1;

public class Solution_12947 {
	// 하샤드 수 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12947
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public boolean solution(int x) {
			String s = String.valueOf(x);
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				sum += s.charAt(i) - 48;
			}
			return x % sum == 0 ? true : false;
		}

	}

}
