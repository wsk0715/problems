package kr.co.programmers.school.solved;

public class Solution_86051 {
	// 없는 숫자 더하기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/86051
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] n) {
			int[] arr = new int[10];
			for (int i = 0; i < n.length; i++) {
				arr[n[i]] += 1;
			}
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += (arr[i] == 0) ? i : 0;
			}
			return sum;
		}

	}

}
