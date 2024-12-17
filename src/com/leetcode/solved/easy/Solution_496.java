package com.leetcode.solved.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_496 {

	// 496. Next Greater Element I - Easy
	// https://leetcode.com/problems/next-greater-element-i
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums1 = {4, 1, 2};
		int[] nums2 = {1, 3, 4, 2};
		System.out.println(Arrays.toString(sol.nextGreaterElement(nums1, nums2)));
	}

	static class Solution {

		public int[] nextGreaterElement(int[] nums1, int[] nums2) {
			// 1. next greater number란 x가 속한 배열에서 우측에 있는 요소 중 첫 번째로 나타나는 x보다 큰 요소를 의미한다.
			// 2. nums2 배열에서 nums1의 각 요소의 next greater number를 계산한 배열 ans를 반환하라.
			// 2-1. nuns1 배열은 nums2 배열의 부분집합이다.
			// 2-2. nums1[i]와 동일한 값을 갖는 nums2[j]를 찾는다.
			// 2-3. nums2[j]의 우측에 있는 값 중 첫 번째로 큰 값을 구한다.
			// 2-4. 만약 더 큰 값이 없다면, 해당 결과는 -1이 된다.

			// nums1, nums2의 길이는 1 이상, 1000 이하이다.
			// nums1[i], nums2[i]는 0 이상, 10^4 이하이다.
			// nums1과 nums2의 모든 원소는 고유하다.


			Map<Integer, Integer> nextGreaterMap = new HashMap<>();
			Stack<Integer> stack = new Stack<>();

			for (int num : nums2) {
				while (!stack.isEmpty() && stack.peek() < num) {
					nextGreaterMap.put(stack.pop(), num);
				}
				stack.push(num);
			}

			while (!stack.isEmpty()) {
				nextGreaterMap.put(stack.pop(), -1);
			}

			int[] result = new int[nums1.length];
			for (int i = 0; i < nums1.length; i++) {
				result[i] = nextGreaterMap.get(nums1[i]);
			}

			return result;
		}

	}

}
