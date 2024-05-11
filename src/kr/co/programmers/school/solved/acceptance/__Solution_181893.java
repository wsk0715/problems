package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class __Solution_181893 {
	// 배열 조각하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181893
	public static void main(String[] args) {
		Solution sol = new Solution();

		sol.solution(new int[]{0, 1, 2, 3, 4, 5}, new int[]{4, 1, 2});
	}

	static class Solution {
		public int[] solution(int[] arr, int[] query) {
			Deque<Integer> dq = new ArrayDeque<>(Arrays.stream(arr)
													   .boxed()
													   .collect(Collectors.toList()));
			for (int i = 0; i < query.length; i++) {
				int q = query[i];
				if (i % 2 == 0) {
					int l = dq.size();
					for (int j = l - 1; j > q; j--) {
						dq.removeLast();
					}
					continue;
				}
				for (int j = 0; j < q; j++) {
					dq.removeFirst();
				}
			}
			return dq.stream()
					 .mapToInt(i -> i)
					 .toArray();
		}

	}

}
