package com.leetcode.solved.easy;

import java.util.PriorityQueue;

public class Solution_703 {

	// 703. Kth Largest Element in a Stream - Easy
	// https://leetcode.com/problems/kth-largest-element-in-a-stream
	public static void main(String[] args) {
		// #case 1
		KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));
	}

	static class KthLargest {

		public int k;

		PriorityQueue<Integer> minHeap;

		public KthLargest(int k, int[] nums) {
			this.k = k;
			minHeap = new PriorityQueue<>();

			for (int n : nums) {
				add(n);
			}
		}

		public int add(int val) {
			if (minHeap.size() < k) {
				minHeap.offer(val);
			} else if (minHeap.peek() < val) {
				minHeap.poll();
				minHeap.offer(val);
			}

			return minHeap.peek();
		}

	}

}
