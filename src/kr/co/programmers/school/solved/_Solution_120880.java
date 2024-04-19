package kr.co.programmers.school.solved;

import java.util.ArrayList;
import java.util.Arrays;

public class _Solution_120880 {
	// 특이한 정렬
	// https://school.programmers.co.kr/learn/courses/30/lessons/120880
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] arr = {10000, 20, 36, 47, 40, 6, 10, 7000, 30};
		int t = 30;
		sol.solution(arr, t);
	}

	static class Solution {
		public int[] solution(int[] arr, int t) {
			Arrays.sort(arr);
			// 0. 값을 저장할 배열과, 차이를 저장할 배열 생성
			int[] narr = new int[arr.length];
			int[] diffs = new int[arr.length];

			// 1. 복제된 배열과, 차를 나타내는 배열에 값을 삽입
			// 1-1.narr: 더 큰 수를 우선으로 정렬하기 위해 내림차순으로 삽입
			for (int i = 0; i < diffs.length; i++) {
				narr[diffs.length - 1 - i] = arr[i];
			}

			// 1-2.diff: 각각의 요소와 t의 차 삽입
			for (int i = 0; i < diffs.length; i++) {
				diffs[diffs.length - 1 - i] = Math.abs(t - arr[i]);
			}

			// 2. 가까운 순서대로 정렬, 이미 내림차순으로 정렬했기 때문에 큰 수가 우선으로 담긴다.
			int n = narr.length - 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					if (diffs[j] > diffs[j + 1]) {  // 차이를 비교한 후
						// 원래 배열의 요소를 정렬
						int tmp2 = narr[j];
						narr[j] = narr[j + 1];
						narr[j + 1] = tmp2;

						// 차를 정렬
						int tmp1 = diffs[j];
						diffs[j] = diffs[j + 1];
						diffs[j + 1] = tmp1;
					}
				}
			}
			return narr;
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
