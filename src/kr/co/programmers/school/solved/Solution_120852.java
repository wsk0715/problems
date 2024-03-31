package kr.co.programmers.school.solved;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_120852 {
	// 소인수분해
	// https://school.programmers.co.kr/learn/courses/30/lessons/120852
	public static void main(String[] args) {
		Solution sol = new Solution();

		int input = 420;
		System.out.println(Arrays.toString(sol.solution(input)));
	}

	static class Solution {
		public int[] solution(int n) {
			// n이 소수라면, n 반환
			if (isPrime(n)) {
				return new int[]{n};
			}

			// 나눌 소수 구하기
			ArrayList<Integer> primes = getPrimes(n);
			// 소인수분해 결과를 구하는 것이 아닌, 해당 소수로 나뉘는지만 확인하면 된다.
			ArrayList<Integer> result = new ArrayList<>();
			for (int i = 0; i < primes.size(); i++) {
				int m = primes.get(i);
				boolean condition = (n / m > 0) && (n % m == 0);
				if (condition) {
					result.add(m);
				}
			}
			return toArray(result);
		}

		// 소수인지 판별하는 메서드
		public boolean isPrime(int n) {
			if (n == 2) {
				return true; // 2는 소수이다.
			}
			if (n % 2 == 0) {
				return false;  // 짝수이면, 소수가 아니다
			}
			// 홀수에 대해
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					return false;  // 1과, 자신을 제외한 수로 나뉘면, 소수가 아니다
				}
			}
			return true;  // 전부 통과했으면(한번도 나뉘지 않았으면) 소수이다
		}

		// n/2 이하의 소수 배열을 구하는 메서드
		public ArrayList<Integer> getPrimes(int n) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 2; i <= n / 2; i++) {
				if (isPrime(i)) {
					arr.add(i);
				}
			}
			return arr;
		}

		// Libraries
		private int[] toArray(ArrayList<Integer> al) {
			// ArrayList<Integer> to int[]
			int[] arr = new int[al.size()];
			for (int i = 0; i < al.size(); i++) {
				arr[i] = al.get(i);
			}
			return arr;
		}

	}

}
