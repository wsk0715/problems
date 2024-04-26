package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_120862 {
	// 최댓값 만들기(2)
	// https://school.programmers.co.kr/learn/courses/30/lessons/120862
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] input = {0, -31, 24, 10, 1, 9};
		System.out.println(sol.solution(input));
	}

	static class Solution {
		public int solution(int[] numbers) {
			ArrayList<Integer> pos = new ArrayList<>();
			ArrayList<Integer> neg = new ArrayList<>();

			for (int i = 0; i < numbers.length; i++) {
				int n = numbers[i];
				if (n < 0) {
					neg.add(n);
				} else {
					pos.add(n);
				}
			}
			Collections.sort(pos);
			Collections.sort(neg);

			int a, b;
			a = (pos.size() > 1) ? pos.get(pos.size() - 1) * pos.get(pos.size() - 2) : 0;
			b = (neg.size() > 1) ? neg.get(neg.size() - 1) * neg.get(neg.size() - 2) : 0;

			return (numbers.length == 2) ? numbers[0] * numbers[1] : (a < b) ? b : a;
		}

	}

}
