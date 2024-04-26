package kr.co.programmers.school.solved.beginner;

public class Solution_120899 {
	// 가장 큰 수 고르기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120899
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] array) {
			int[] seqs = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				int seq = 1;
				for (int j = 0; j < array.length; j++) {
					if (array[i] < array[j]) {
						seq++;
					}
				}
				seqs[i] = seq;
			}

			int idx = 0;
			for (int i = 0; i < seqs.length; i++) {
				if (seqs[i] == 1) {
					idx += i;
					break;
				}
			}

			return new int[]{array[idx], idx};
		}

	}

}
