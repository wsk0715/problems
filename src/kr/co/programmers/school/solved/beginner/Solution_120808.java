package kr.co.programmers.school.solved.beginner;

public class Solution_120808 {
	// 분수의 덧셈
	// https://school.programmers.co.kr/learn/courses/30/lessons/120808
	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int bunja, bunmo;
		bunmo = denom1 * denom2;
		bunja = (numer1 * denom2 + numer2 * denom1);

		int gcd = getGCD(bunmo, bunja);
		return new int[]{bunja / gcd, bunmo / gcd};
	}

	public int getGCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getGCD(b, a % b);
	}

}
