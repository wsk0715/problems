package kr.co.programmers.school.solved.acceptance;

import java.math.BigInteger;

public class Solution_181846 {
	// 두 수의 합
	// https://school.programmers.co.kr/learn/courses/30/lessons/181846
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String a, String b) {
			BigInteger A = new BigInteger(a);
			BigInteger B = new BigInteger(b);
			return A.add(B)
					.toString();
		}

	}

}
