package com.leetcode.solved.easy;

public class _Solution_191 {

	// 191. Number of 1 Bits - Easy
	// https://leetcode.com/problems/number-of-1-bits
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int n = 11;
		System.out.println(sol.hammingWeight(n));
		// #case 2
		int n2 = 128;
		System.out.println(sol.hammingWeight(n2));
		// #case 3
		int n3 = 2_147_483_645;
		System.out.println(sol.hammingWeight(n3));
	}

	static class Solution {

		public int hammingWeight(int n) {
			// 1. 양의 정수 n이 입력으로 주어진다.
			// 2. n의 set bit(=hamming weight)의 수를 구하는 함수를 작성하라.
			// 2-1. set bit는 이진법으로 표현했을 때 특정 비트의 값이 1로 설정된 상태를 의미한다.
			// 3. n의 범위는 1 이상, 3^31 - 1 이하이다.

			// a. 시프트 연산 활용
			int count = 0;
			int MASK = 0x00000001;  // 00000000 00000000 00000000 00000001
			while (n != 0) {
				count += n & MASK;  // a-1. 설정한 비트 마스크와 AND 연산, 우측 맨 끝 비트가 1인지 확인한다.
				n >>= 1;
			}

			// b. 결과 반환
			return count;
		}

	}

}
