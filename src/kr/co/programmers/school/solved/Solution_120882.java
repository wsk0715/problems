package kr.co.programmers.school.solved;

public class Solution_120882 {
	// 등수 매기기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120882
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[][] score) {
			int[] sums = new int[score.length];
			for (int i = 0; i < sums.length; i++) {
				sums[i] = score[i][0] + score[i][1];
			}

			int[] result = new int[sums.length];
			int count;
			for (int i = 0; i < sums.length; i++) {
				count = 1;
				for (int j = 0; j < sums.length; j++) {
					if (sums[i] < sums[j]) {
						count++;
					}
				}
				result[i] = count;
			}
			return result;
		}

	}

}
