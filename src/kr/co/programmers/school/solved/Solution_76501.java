package kr.co.programmers.school.solved;

public class Solution_76501 {
	// 음양 더하기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/76501
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] absolutes, boolean[] signs) {
			int[] arr = new int[absolutes.length];
			for (int i = 0; i < absolutes.length; i++) {
				arr[i] = (signs[i]) ? absolutes[i] : -absolutes[i];
			}
			int sum = 0;
			for (int n : arr) {
				sum += n;
			}
			return sum;
		}

	}

}
