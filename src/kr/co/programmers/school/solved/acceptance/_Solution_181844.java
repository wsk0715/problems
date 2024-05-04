package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181844 {
	// 배열의 원소 삭제하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181844
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] n, int[] d) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < n.length; i++) {
				boolean con = false;
				for (int j = 0; j < d.length; j++) {
					if (n[i] == d[j]) {
						con = true;
						break;
					}
				}

				if (con) {
					continue;
				}
				al.add(n[i]);
			}
			return toArray(al);
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

}
