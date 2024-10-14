package com.leetcode.solved.easy;

public class __Solution_704 {

	// 704. Binary Search - Easy
	// https://leetcode.com/problems/binary-search
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target = 9;
		System.out.println(sol.search(nums, target));
		// #case 2
		int[] nums2 = {-1, 0, 3, 5, 9, 12};
		int target2 = 2;
		System.out.println(sol.search(nums2, target2));
	}

	static class Solution {

		public int search(int[] nums, int target) {
			// 1. 배열 nums 안에 정수 target이 존재하는지 판별한다.
			// 2. nums의 길이는 1 이상, 10^4 이하이다.
			// 2-1. nums의 모든 원소는 중복되지 않는다.
			// 2-2. nums는 오름차순으로 정렬되어있다.

			// a. 초기 탐색 범위, 포인터 지정
			int left = 0;  // a-1. 탐색 대상 좌측 끝범위
			int right = nums.length - 1;  // a-2. 탐색 대상 우측 끝범위, 마지막 인덱스
			int idx;  // a-3. 포인터, 중앙 인덱스

			// b. 탐색 수행
			while (left <= right) {  // b-1. 종료조건, 탐색 범위가 정상적일 때
				idx = (left + right) / 2;  // 탐색 범위 중앙 인덱스를 포인터로 설정한다.

				// b-2. 포인터가 위치한 값이 타겟과 일치한다면
				if (nums[idx] == target) {
					return idx;  // 인덱스 반환
				}

				if (nums[idx] < target) {  // b-3. 포인터보다 우측에 있는 경우
					left = idx + 1;  // 좌측 끝범위를 현재 포인터 위치 이후로 설정한다.
				} else {  // b-4. 포인터보다 좌측에 있는 경우
					right = idx - 1;  // 우측 끝범위를 현재 포인터 위치 이전으로 설정한다.
				}
			}

			return -1;  // c. 타겟 값을 찾지 못한 경우, -1 반환
		}

	}

}
