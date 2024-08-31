package com.codility.app.solved.lesson13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lesson13_Task1 {

	// Lesson 13 - Fibonacci numbers: FibFrog
	// https://app.codility.com/programmers/lessons/13-fibonacci_numbers/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);

		int[] A2 = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
		int result2 = sol.solution(A2);
		System.out.printf("result A2: %s\n", result2);
	}

	static class Solution {

		public int solution(int[] A) {
			int N = A.length;

			// a. compute fibonacci sequence
			List<Integer> fibo = new ArrayList<>();
			fibo.add(1);
			fibo.add(1);
			int next;
			while ((next = fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2)) <= N + 1) {
				fibo.add(next);
			}

			// b. compute minumum jumps using BFS
			Queue<Frog> queue = new LinkedList<>();
			boolean[] visited = new boolean[N + 1];
			queue.offer(new Frog(-1, 0));

			while (!queue.isEmpty()) {
				Frog frog = queue.poll();
				int pos = frog.pos;
				int jumps = frog.jumps;

				for (int i : fibo) {
					int newPos = pos + i;

					// check if new position is N(end of the river)
					if (newPos == N) {
						return jumps + 1;
					}

					// next jump, where is not visited, exists leaf
					if (newPos < N && !visited[newPos] && A[newPos] == 1) {
						queue.offer(new Frog(newPos, jumps + 1));
						visited[newPos] = true;
					}
				}
			}

			return -1;
		}

		static class Frog {

			int pos;
			int jumps;

			public Frog(int pos, int jumps) {
				this.pos = pos;
				this.jumps = jumps;
			}

		}

	}

}
