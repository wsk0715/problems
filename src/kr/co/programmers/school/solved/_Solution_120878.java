package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class _Solution_120878 {
	// 유한소수 판별하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120878
	public static void main(String[] args) {
		Solution sol = new Solution();

		int a = 990;
		int b = 500;
		sol.solution(a, b);
	}

	static class Solution {
		public int solution(int a, int b) {
			int r = 1;

			// 유한소수: 기약분수로 나타냈을 때, 분모의 소인수가 2와 5만 존재해야 한다.
			// 소인수: 약수 중 소수인 수

			// 0. 예외케이스
			if (a % b == 0) {  // 정수인 경우
				return 1;
			}

			// 1. a, b를 기약분수로 나타낸다.
			// 1-1. 최대공약수를 구한다.
			int g = getGcd(a, b);

			// 1-2. a,b를 기약분수로 나타낸다.
			a /= g;
			b /= g;
			System.out.println(a + " " + b);

			// 2. b의 약수를 구한다.
			ArrayList<Integer> d = getDivisors(b);
			System.out.println(d);

			// 2-1. b의 약수 중 소수를 구한다.
			ArrayList<Integer> pd = new ArrayList<>();
			for (int i = 0; i < d.size(); i++) {
				int m = d.get(i);
				if (isPrime(m)) {
					pd.add(m);
				}
			}
			System.out.println(pd);

			// 3. b의 소수인 약수 중 2, 5가 아닌 수가 있는지 확인한다.
			for (int i = 0; i < pd.size(); i++) {
				if (pd.get(i) != 2 && pd.get(i) != 5) {
					r++;
					break;
				}
			}
			System.out.println(r);

			return r;
		}

		private ArrayList<Integer> getDivisors(int n) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 2; i <= n; i++) {
				if (n % i == 0) {
					al.add(i);
				}
			}
			return al;
		}

		private boolean isPrime(int n) {
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}

		public int getGcd(int a, int b) {
			if (b == 0) {
				return a;
			}
			return getGcd(b, a % b);
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
