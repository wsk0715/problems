package kr.co.programmers.school.solved.lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_12941 {
	// 최솟값 만들기 - lv.2
	// https://school.programmers.co.kr/learn/courses/30/lessons/12941
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] A, int[] B) {
			int r = 0;
			// 1. 수를 하나씩 뽑아 곱한다. (배열의 길이만큼 반복)
			// 2. 각각의 수를 더한 총합이 최소가 되도록 한다.
			// -> A의 가장 큰 수를 B의 가장 작은 수와 곱하는 과정 반복

			Arrays.sort(A);
			Arrays.sort(B);
			int l = A.length - 1;
			for (int i = l; i >= 0; i--) {
				r += A[i] * B[l - i];
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
