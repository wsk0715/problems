package com.leetcode.solved.medium;

import java.util.Arrays;

public class __Solution_238 {

	// 238. Product of Array Except Self - Medium
	// https://leetcode.com/problems/product-of-array-except-self
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {1, 2, 3, 4};
		System.out.println(Arrays.toString(sol.productExceptSelf(nums)));
		// #case 2
		int[] nums2 = {-1, 1, 0, -3, 3};
		System.out.println(Arrays.toString(sol.productExceptSelf(nums2)));
	}

	static class Solution {

		public int[] productExceptSelf(int[] nums) {
			// 1. 입력으로 배열 nums가 주어진다.
			// 2. answer[i]의 값으로 nums의 i번째 원소를 제외한 모든 곱을 갖도록 하는 배열 answer를 반환한다.
			// 3. nums의 범위는 2 이상, 10^5 이하이다.
			// 3-1. nums의 각 원소 nums[i]는 -30 이상, 30 이하의 값을 가진다.
			// 3-2. prefix product, suffix product 값은 항상 int 형태임이 보장된다.(32bit = 4byte)
			// 3-3. 시간 복잡도 O(n) 안에 실행되는 알고리즘을 구현해야한다.

			// a. 결과 배열 생성
			int[] result = new int[nums.length];

			// b. 좌측 누적 곱 먼저 계산
			int leftValue = 1;  // 좌측 누적될 값
			for (int i = 0; i < nums.length; i++) {
				result[i] = leftValue;  // 최초 반복과 동시에 초기화
				leftValue *= nums[i];  // 결과 저장 후에 자기자신을 곱한다.
			}

			// c. 우측 누적 곱 계산
			int rightValue = 1;  // 우측 누적될 값
			for (int i = nums.length - 1; i >= 0; i--) {
				result[i] *= rightValue;
				rightValue *= nums[i];
			}

			return result;
		}

	}

}
