package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181926 {
	// 수 조작하기 1
	// https://school.programmers.co.kr/learn/courses/30/lessons/181926
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n, String s) {
			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
					case 'w':
						n += 1;
						break;
					case 's':
						n -= 1;
						break;
					case 'd':
						n += 10;
						break;
					case 'a':
						n -= 10;
						break;
				}
			}
			return n;
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
