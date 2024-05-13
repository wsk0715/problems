package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class __Solution_181851 {
	// 전국대회 선발고사
	// https://school.programmers.co.kr/learn/courses/30/lessons/181851
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] rank, boolean[] attendance) {
			for (int i = 0; i < attendance.length; i++) {
				if (!attendance[i]) {
					rank[i] = Integer.MAX_VALUE;
				}
			}
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				int min = Integer.MAX_VALUE;
				int minIdx = -1;
				for (int j = 0; j < rank.length; j++) {
					if (rank[j] < min) {
						min = rank[j];
						minIdx = j;
					}
				}
				al.add(minIdx);
				rank[minIdx] = Integer.MAX_VALUE;
			}
			int r1 = al.get(0);
			int r2 = al.get(1);
			int r3 = al.get(2);
			return 10000 * r1 + 100 * r2 + r3;
		}

	}

}
