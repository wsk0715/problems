package com.codility.app.solved.lesson7;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lesson7_Task2 {

	// Lesson 7 - Stacks and Queues: Fish
	// https://app.codility.com/programmers/lessons/7-stacks_and_queues/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {4, 3, 2, 1, 5};
		int[] B = {0, 1, 0, 0, 0};
		int result = sol.solution(A, B);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A, int[] B) {
			Deque<Integer> deque = new ArrayDeque<>();  // fishes moving donwstream
			int alive = 0;  // fishes already moved upstream

			for (int i = 0; i < B.length; i++) {
				if (B[i] == 1) {  // a. moving downstream
					deque.push(A[i]);
				} else if (B[i] == 0) {  // b. moving upstream
					while (!deque.isEmpty()) {
						if (deque.peek() < A[i]) {
							deque.pop();
						} else if (deque.peek() > A[i]) {
							break;
						}
					}
					if (deque.isEmpty()) {
						alive += 1;
					}
				}
			}

			return alive + deque.size();
		}

	}

}
