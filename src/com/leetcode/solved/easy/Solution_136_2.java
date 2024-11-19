package com.leetcode.solved.easy;

public class Solution_136_2 {

	// 136. Single Number - Easy
	// https://leetcode.com/problems/single-number
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {2, 2, 1};
		System.out.println(sol.singleNumber(nums));
	}

	static class Solution {

		public int singleNumber(int[] nums) {
			// 1. nums는 하나의 원소를 제외한 나머지 원소들이 두 번씩 나타나는 정수 배열이다.
			// 1-1. 두 번 나타나지 않은 하나의 원소를 찾아내 반환하라.
			// 2. nums의 길이는 1 이상, 3 * 10^4 이하이다.
			// 2-1. nums[i]는 -3 * 10^4 이상, 3 * 10^4 이하이다.


			// Single Number 다른 풀이
			// 비트 연산의 XOR 연산자(^) 활용
			// 비트 연산자 XOR(^)은 다음과 같은 특징을 갖는다.
			// 1. a와 b가 같은 수일 때 연산의 결과는 0
			// 2. a가 0, b가 임의의 정수일 때 연산 결과는 b
			// 3. XOR 연산은 교환법칙과 결합법칙이 성립
			// 이러한 성질을 이용해 배열의 모든 수를 XOR 연산하면 짝수 번 나타난 수는 상쇄되고, 한 번만 나타난 숫자만 남게된다.

			int result = 0;  // XOR 연산을 누적시킬 값
			for (int n : nums) {
				result ^= n;  // 현재까지 누적된 값과 XOR 연산
			}
			return result;
		}

	}

}
