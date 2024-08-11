package com.codility.app.solved.lesson8;

public class Lesson8_Task2 {

	// Lesson 8 - Leader: EquiLeader
	// https://app.codility.com/programmers/lessons/8-leader/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {4, 3, 4, 4, 4, 2};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int N = A.length;

			// find the candidate for the leader
			int candidate = A[0];
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (count == 0) {
					candidate = A[i];
					count += 1;
				} else {
					if (A[i] == candidate) {
						count += 1;
					} else {
						count -= 1;
					}
				}
			}

			// verify if the candidate is the leader
			count = 0;
			for (int i = 0; i < N; i++) {
				if (A[i] == candidate) {
					count += 1;
				}
			}

			// check if candidate is a leader
			if (count <= N / 2) {
				return 0;
			}

			int leader = candidate;
			int equiLeaders = 0;
			int leftLeaderCount = 0;

			// count the number of equi leaders
			for (int i = 0; i < N - 1; i++) {
				if (A[i] == leader) {
					leftLeaderCount += 1;
				}
				int leftSize = i + 1;
				int rightSize = N - leftSize;
				if (leftLeaderCount > leftSize / 2 && (count - leftLeaderCount) > rightSize / 2) {
					equiLeaders += 1;
				}
			}

			return equiLeaders;
		}

	}

}
