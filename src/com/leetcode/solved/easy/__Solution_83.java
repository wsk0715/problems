package com.leetcode.solved.easy;

import com.leetcode.util.ListNode;

public class __Solution_83 {

	// 83. Remove Duplicates from Sorted List - Easy
	// https://leetcode.com/problems/remove-duplicates-from-sorted-list
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
		System.out.println(sol.deleteDuplicates(head));
	}

	static class Solution {

		public ListNode deleteDuplicates(ListNode head) {
			// 1. 정렬되어있는 연결 리스트 head에서 중복되는 원소를 하나만 남기고 제거하라.

			// 리스트의 노드 갯수는 0 이상, 300 이하이다.
			// -100 <= node.val <= 100


			if (head == null || head.next == null) {
				return head;
			}

			ListNode current = head;
			while (current != null && current.next != null) {
				if (current.val == current.next.val) {
					current.next = current.next.next;
				} else {
					current = current.next;
				}
			}

			return head;
		}

	}

}
