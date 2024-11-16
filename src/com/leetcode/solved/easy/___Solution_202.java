package com.leetcode.solved.easy;

import java.util.HashSet;
import java.util.Set;

public class ___Solution_202 {

	// 202. Happy Number - Easy
	// https://leetcode.com/problems/happy-number
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int n = 19;
		System.out.println(sol.isHappy(n));
	}

	static class Solution {

		public boolean isHappy(int n) {
			// 1. happy number는 다음과 같은 조건을 갖는다:
			// 1-1. 임의의 양의 정수에서 시작한다.
			// 1-2. 숫자의 각 자릿수를 제곱한 후, 그 합으로 원래의 수를 대체한다.
			// 1-3. 이 과정을 반복하여, 만약 결과가 1이 될 수 있다면 n은 happy number이다.
			// 2. n의 범위는 1 이상, 2^31 - 1 이하이다.


			Set<Integer> hs = new HashSet<>();
			while (n != 1 && !hs.contains(n)) {
				hs.add(n);
				n = calc(n);
			}

			return n == 1;
		}

		private int calc(int n) {
			int sum = 0;

			// 각 자릿수 계산
			while (n > 0) {
				int digit = n % 10;  // 일의 자리 가져오기
				sum += digit * digit;
				n /= 10;  // 한 칸씩 밀기(십의 자리 -> 일의 자리)
			}

			return sum;
		}

	}

}
