package kr.co.programmers.school.solved;

public class Solution_120912 {
	// 7의 개수
	// https://school.programmers.co.kr/learn/courses/30/lessons/120912
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] array) {
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				String s = String.valueOf(array[i]);
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == '7') {
						count++;
					}
				}
			}
			return count;
		}

	}

}
