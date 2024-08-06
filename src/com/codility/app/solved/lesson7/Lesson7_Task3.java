package com.codility.app.solved.lesson7;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lesson7_Task3 {

	// Lesson 7 - Stacks and Queues: Nesting
	// https://app.codility.com/programmers/lessons/7-stacks_and_queues/
	public static void main(String[] args) {
		Solution sol = new Solution();

		String S = "(()(())())";
		int result = sol.solution(S);
		System.out.printf("result: %s\n", result);

		String S2 = "())";
		int result2 = sol.solution(S2);
		System.out.printf("result: %s\n", result2);
	}

	static class Solution {

		public int solution(String S) {
			char[] chars = S.toCharArray();

			Deque<Character> deque = new ArrayDeque<>();
			for (char c : chars) {
				if (c == '(') {
					deque.push('(');
				} else if (c == ')') {
					if (deque.isEmpty()) {
						return 0;
					}
					deque.pop();
				}
			}

			return deque.isEmpty() ? 1 : 0;
		}

	}

}
