package kr.co.programmers.school.solved;

public class Solution_12954 {
	// x만큼 간격이 있는 n개의 숫자 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12954
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public long[] solution(int x, int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = (long) x * (i + 1);
			}
			return arr;
		}

	}

}
