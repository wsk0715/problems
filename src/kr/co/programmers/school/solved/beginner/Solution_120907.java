package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class Solution_120907 {
	// OX퀴즈
	// https://school.programmers.co.kr/learn/courses/30/lessons/120907
	public static void main(String[] args) {
		Solution sol = new Solution();

		String[] input = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};
		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String[] q) {
			String[] result = new String[q.length];
			for (int i = 0; i < result.length; i++) {
				if (solve(q[i])) {  // 식이 true이면
					result[i] = "O";
					continue;
				}
				// false이면
				result[i] = "X";
			}

			return result;
		}

		public boolean solve(String s) {
			String[] e = s.split(" ");
			String mod = e[1];
			int x = Integer.parseInt(e[0]);
			int y = Integer.parseInt(e[2]);
			int z = Integer.parseInt(e[e.length - 1]);
			// - 연산인 경우
			if (mod.equals("-")) {
				return (z == x - y);
			}
			// + 연산인 경우
			return (z == x + y);
		}

	}


	// Libraries
	private int[] toArray(ArrayList<Integer> al) {
		// ArrayList<Integer> to int[]
		int[] arr = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			arr[i] = al.get(i);
		}
		return arr;
	}

}
