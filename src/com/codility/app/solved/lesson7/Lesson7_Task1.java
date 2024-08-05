package com.codility.app.solved.lesson7;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lesson7_Task1 {

	// Lesson 7 - Stacks and Queues: Brackets
	// https://app.codility.com/programmers/lessons/7-stacks_and_queues/
	public static void main(String[] args) {
		Solution sol = new Solution();

		String S = "{[()()]}";
		int result = sol.solution(S);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(String S) {
			Deque<Character> deque = new ArrayDeque<>();

			char[] chars = S.toCharArray();
			for (char c : chars) {
				switch (c) {
					case '[':
					case '{':
					case '(':
						deque.push(c);
						break;
					case ']':
						if (deque.peek() == null || !deque.peek().equals('[')) {
							return 0;
						}
						deque.pop();
						break;
					case '}':
						if (deque.peek() == null || !deque.peek().equals('{')) {
							return 0;
						}
						deque.pop();
						break;
					case ')':
						if (deque.peek() == null || !deque.peek().equals('(')) {
							return 0;
						}
						deque.pop();
						break;
				}
			}

			return deque.isEmpty() ? 1 : 0;
		}

	}

}
