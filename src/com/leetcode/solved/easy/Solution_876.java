package com.leetcode.solved.easy;

import com.leetcode.util.ListNode;

public class Solution_876 {

	// 876. Middle of the Linked List - Easy
	// https://leetcode.com/problems/middle-of-the-linked-list
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		System.out.println(sol.middleNode(head));
	}

	static class Solution {

		public ListNode middleNode(ListNode head) {
			// 1. 단일 연결 리스트의 헤드(head)가 주어진다.
			// 2. 연결 리스트의 가운데 노드를 반환하라.
			// 2-1. 연결 리스트의 길이가 짝수라면 두 번째 노드를 반환한다.


			int length = 0;
			ListNode current = head;
			while (current != null) {
				length++;
				current = current.next;
			}

			int middleIndex = length / 2;
			current = head;
			for (int i = 0; i < middleIndex; i++) {
				current = current.next;
			}

			return current;
		}

	}

}
