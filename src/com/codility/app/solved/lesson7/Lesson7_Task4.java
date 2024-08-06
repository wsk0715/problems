package com.codility.app.solved.lesson7;

import java.util.Stack;

public class Lesson7_Task4 {

	// Lesson 7 - Stacks and Queues: StoneWall
	// https://app.codility.com/programmers/lessons/7-stacks_and_queues/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
		int result = sol.solution(H);
		System.out.printf("result: %s\n", result);
	}

	static class Solution {

		public int solution(int[] H) {
			Stack<Integer> stack = new Stack<>();

			int count = 0;
			for (int i : H) {
				// a. remove all blocks higher than current height
				while (!stack.isEmpty() && stack.peek() > i) {
					stack.pop();
				}

				// b. when stack is empty or current height is higher than stack's top height
				if (stack.isEmpty() || stack.peek() < i) {
					stack.push(i);
					count += 1;
				}
			}

			return count;
		}

	}

}
