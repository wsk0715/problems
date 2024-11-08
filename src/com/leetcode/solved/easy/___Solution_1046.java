package com.leetcode.solved.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ___Solution_1046 {

	// 1046. Last Stone Weight - Easy
	// https://leetcode.com/problems/last-stone-weight
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {2, 7, 4, 1, 8, 1};
		System.out.println(sol.lastStoneWeight(nums));
	}

	static class Solution {

		public int lastStoneWeight(int[] stones) {
			// 1. 정수로 이루어진 배열 stones가 주어진다.
			// 1-1. stones[i]는 i번째 돌덩이의 무게이다.
			// 2. 가장 무거운 돌 두 개를 골라, 서로 부딪히는 게임을 수행한다.
			// 2-1. 게임은 다음과 다음과 같다:
			// 	i. 만약 두 돌의 무게가 같다면, 둘 다 부숴진다.
			//	ii. 그렇지 않다면, 가벼운 돌은 부숴지고, 큰 돌의 무게는 작은 돌의 무게만큼 감소한다.
			// 2-2. 게임이 종료되고, 최대 한 개의 돌만 남아있을 수 있다.
			// 3. 마지막 남은 돌의 무게를 구하라. 돌이 남아있지 않다면 0을 반환한다.
			// 4. stones의 길이는 1 이상, 30 이하이다.
			// 4-1. 각 돌의 무게는 1 이상, 1000 이하이다.


			// 가장 큰 돌의 무게 -> 우선순위 큐 이용
			PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());  // 내림차순으로 정렬되도록
			for (int stone : stones) {
				queue.offer(stone);
			}

			// smash 수행
			while (!queue.isEmpty()) {
				int heavyFirst = queue.poll();

				if (queue.isEmpty()) {
					return heavyFirst;
				}

				int heavySecond = queue.poll();

				// a. 돌 무게가 같은 경우
				if (heavyFirst == heavySecond) {
					continue;  // 돌을 넣지 않고(제거) 다음 반복으로
				}

				// b. 돌 크기가 다른 경우
				if (heavyFirst > heavySecond) {
					heavyFirst -= heavySecond;  // 돌을 부딪힌 후
					queue.offer(heavyFirst);  // 부딪힌 큰 돌을 다시 큐에 삽입
				}
			}

			return 0;
		}

	}

}
