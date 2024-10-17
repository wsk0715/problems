package com.leetcode.solved.medium;

public class __Solution_371 {

	// 371. Sum of Two Integers - Medium
	// https://leetcode.com/problems/sum-of-two-integers
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int a = 1;
		int b = 2;
		System.out.println(sol.getSum(a, b));
		// #case 2
		int a2 = 1;
		int b2 = 2;
		System.out.println(sol.getSum(a2, b2));
	}

	static class Solution {

		public int getSum(int a, int b) {
			// 1. +, - 연산자를 사용하지 않고 두 정수 a, b의 합을 구해야한다.
			// 2. a, b의 범위는 -1000 이상, 1000 이하이다.

			// 비트 연산 활용
			// a. 비트 연산을 통해 덧셈을 표현할 때는 XOR, AND, 시프트 연산자를 활용한다.
			// a-1. ^(XOR) 연산 - 두 비트 값이 서로 다를 때 1, 같을 때 0 반환
			// a-2. &(AND) 연산 - 두 비트 값이 같을 때 1, 다를 때 0 반환
			// a-3. <<(시프트) 연산 - 왼쪽 시프트 연산자, 모든 비트를 왼쪽으로 특정 비트 수만큼 이동시킴

			// a. 32비트 마스크, 최댓값(부호 비트를 제외한 최대값) 표현
			int MASK = 0xFFFFFFFF;  // 11111111 11111111 11111111 11111111 = -1
			int MAX = 0x7FFFFFFF;  // 01111111 11111111 11111111 11111111 = Integer.MAX_VALUE

			// b. 비트 연산 수행
			while (b != 0) {
				// b-1. XOR을 사용하여 합을 구하고, AND 후 시프트하여 자리올림을 계산
				int sum = (a ^ b) & MASK;
				int carry = ((a & b) << 1) & MASK;
				a = sum;
				b = carry;
			}

			// c. 음수 처리
			return a <= MAX ? a : ~(a ^ MASK);
		}

	}

}
