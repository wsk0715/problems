package com.leetcode.solved.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __Solution_15 {

	// 15. 3Sum - Medium
	// https://leetcode.com/problems/3sum
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(sol.threeSum(nums));
		// #case 2
		int[] nums2 = {0, 1, 1};
		System.out.println(sol.threeSum(nums2));
		// #case 3
		int[] nums3 = {0, 0, 0};
		System.out.println(sol.threeSum(nums3));
	}

	static class Solution {

		public List<List<Integer>> threeSum(int[] nums) {
			// 1. 정수로 이루어진 배열 nums가 입력으로 주어진다.
			// 2. i != j이고, i != k이고, j != k인 모든 순서쌍(triplet) [nums[i], nums[j], nums[k]]을 반환하라.
			// 2-1. 단, nums[i] + nums[j] + nums[k] == 0이다.
			// 2-2. 순서쌍 원소의 순서는 고려하지 않는다. (조합의 개념)
			// 3. nums의 길이는 3 이상, 3000 이하이다.
			// 3-1. nums[i]의 범위는 -10^5 이상, 10^5 이하이다.

			// a. 무작위 배열 nums를 정렬
			Arrays.sort(nums);

			// b. 주어진 조건에 따라 탐색, 투 포인터 기법 사용
			// b-1. 첫 번째(i) 숫자를 정하고, 왼쪽 끝 범위와 오른쪽 끝 범위를 서로 좁혀가면서 탐색
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < nums.length - 2; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {  // 이전과 동일한 숫자가 나올 시,
					continue;  // 다음 루프로 이동
				}

				int left = i + 1;
				int right = nums.length - 1;

				while (left < right) {  // b-2. 종료 조건, 탐색 범위가 정상적일 때
					int sum = nums[i] + nums[left] + nums[right];

					if (sum == 0) {  // b-3. 조건을 만족한 경우,
						result.add(List.of(nums[i], nums[left], nums[right]));  // 결과 배열에 더한다.

						while (left < right && nums[left] == nums[left + 1]) {  // 동일한 요소를 전부 건너뛴다.
							left += 1;
						}
						while (left < right && nums[right] == nums[right - 1]) {  // 동일한 요소를 전부 건너뛴다.
							right -= 1;
						}

						left += 1;
						right -= 1;
					} else if (sum < 0) {  // b-4. 합이 0보다 작은 경우,
						left += 1;  // 좌측 포인터를 한 칸 움직인다.
					} else {  // b-5. 합이 0보다 큰 경우
						right -= 1;  // 우측 포인터를 한 칸 움직인다.
					}
				}
			}

			return result;
		}

	}

}
