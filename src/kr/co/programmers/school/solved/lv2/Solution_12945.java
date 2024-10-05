package kr.co.programmers.school.solved.lv2;

public class Solution_12945 {

	// 피보나치 수 - lv.2
	// https://school.programmers.co.kr/learn/courses/30/lessons/12945
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int n = 3;
		System.out.println(sol.solution(n));
		// #case 2
		int n2 = 5;
		System.out.println(sol.solution(n2));
	}

	static class Solution {

		public int solution(int n) {
			long[] fibo = new long[n + 1];
			fibo[0] = 0;
			fibo[1] = 1;

			for (int i = 2; i < fibo.length; i++) {
				fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
			}

			return (int) fibo[n];
		}

	}

}
