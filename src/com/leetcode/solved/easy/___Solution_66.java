package com.leetcode.solved.easy;

import java.util.Arrays;

public class ___Solution_66 {

	// 66. Plus One - Easy
	// https://leetcode.com/problems/plus-one
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] digits = {1, 2, 3};
		System.out.println(Arrays.toString(sol.plusOne(digits)));
		// #case 2
		int[] digits2 = {4, 3, 2, 1};
		System.out.println(Arrays.toString(sol.plusOne(digits2)));
		// #case 3
		int[] digits3 = {9};
		System.out.println(Arrays.toString(sol.plusOne(digits3)));
	}

	static class Solution {

		public int[] plusOne(int[] digits) {
			// 1. digits는 어떤 큰 정수를 배열로 표시한 것이다.(digits[i]는 i번째 자리 숫자)
			// 1-1. 배열은 왼쪽(높은 자리)에서 오른쪽(낮은 자리)로 나열되어 있다. -> 배열 순서와 숫자의 순서 동일
			// 2. 이 숫자에 1을 더한 값을 배열로 반환하라.
			// 3. 맨 앞 숫자로는 0이 오지 않는다.
			// 3-1. digits의 길이는 1 이상, 100 이하이다.
			// 3-2. digits[i]는 0 이상, 9 이하이다.


			int N = digits.length;
			for (int i = N - 1; i >= 0; i--) {
				digits[i] += 1;

				// 자리 올림이 존재하는지 확인
				if (digits[i] < 10) {
					return digits;
				}

				digits[i] = 0;
			}

			// 모든 자릿수가 올려진 경우
			int[] result = new int[N + 1];  // 모든 자릿수는 0
			result[0] = 1;  // 첫번째 자리만 1
			return result;
		}

	}

}
