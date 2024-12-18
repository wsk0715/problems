package com.leetcode.solved.easy;

import java.util.Arrays;

public class ___Solution_88 {

	// 88. Merge Sorted Array - Easy
	// https://leetcode.com/problems/merge-sorted-array
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int m = 3;
		int[] nums2 = {2, 5, 6};
		int n = 3;
		sol.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));

		// #case 2
		int[] nums21 = {1};
		int m2 = 1;
		int[] nums22 = {};
		int n2 = 0;
		sol.merge(nums21, m2, nums22, n2);
		System.out.println(Arrays.toString(nums21));

		// #case 2
		int[] nums31 = {2, 0};
		int m3 = 1;
		int[] nums32 = {1};
		int n3 = 1;
		sol.merge(nums31, m3, nums32, n3);
		System.out.println(Arrays.toString(nums31));
	}

	static class Solution {

		public void merge(int[] nums1, int m, int[] nums2, int n) {
			// 1. 오름차순으로 정렬된 정수 배열 nums1, nums2와 정수 m, n이 주어진다.
			// 2. nums1과 nums2 배열을 오름차순으로 병합하라.
			// 2-1. nums1 배열에 정렬이 완료된 결과 배열을 담아야 한다. (반환하는것이 아님)
			// 3. nums1에서 m개의 원소, nums2에서 n개의 원소를 사용한다.
			// 3-1. nums1에서 m개의 원소를 제외한 나머지 원소는 0인 상태로 전달받는다.

			// nums1의 길이는 m + n
			// nums2의 길이는 n
			// 0 <= m, n <= 200
			// 1 <= m + n <= 200
			// -10^9 <= nums1[i], nums2[j] <= 10^9


			// 예외 처리
			if (n == 0) {
				return;
			}

			// a. 포인터 설정
			int p1 = m - 1; // nums1 유효(0이 아닌) 포인터
			int p2 = n - 1; // nums2 포인터
			int p = m + n - 1; // 병합 결과를 채울 위치

			// b. 두 배열을 뒤에서부터 비교하며 병합
			while (p1 >= 0 && p2 >= 0) {
				if (nums1[p1] > nums2[p2]) {
					nums1[p--] = nums1[p1--];
				} else {
					nums1[p--] = nums2[p2--];
				}
			}

			// c. nums2에 남은 요소가 있다면 nums1에 복사
			while (p2 >= 0) {
				nums1[p--] = nums2[p2--];
			}
		}

	}

}
