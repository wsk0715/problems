package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181935 {
	// 홀짝에 따라 다른 값 반환하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181935
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			int r = 0;
			if (n % 2 == 0) {
				for (int i = 0; i <= n; i += 2) {
					r += i * i;
				}
				return r;
			}
			for (int i = 1; i <= n; i += 2) {
				r += i;
			}
			return r;
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
