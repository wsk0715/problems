package com.leetcode.solved.easy;

import java.util.Stack;

public class Solution_206_2 {

	// 0. blah blah - Easy
	// https://leetcode.com/problems/blah-blah
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		System.out.println(sol.reverseList(head));
	}

	static class Solution {

		public ListNode reverseList(ListNode head) {
			// 1. 단일 연결 리스트(singly linked list) haed가 주어진다.
			// 2. head를 뒤집은 리스트를 반환하라.

			// 빈 입력값에 대한 예외처리
			if (head == null) {
				return null;
			}

			// a. 순서대로 꺼내서 스택에 집어넣는다.
			Stack<Integer> stack = new Stack<>();
			ListNode p = head;
			while (p != null) {
				stack.add(p.val);
				p = p.next;
			}

			// b. 스택에서 값을 꺼내며 새로운 연결 리스트를 만든다.
			ListNode result = new ListNode();
			ListNode p2 = result;
			while (!stack.isEmpty()) {
				p2.val = stack.pop();
				if (!stack.isEmpty()) {
					p2.next = new ListNode();
					p2 = p2.next;
				}
			}

			return result;
		}

	}

	public static class ListNode {

		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			if (this.next != null) {
				return String.format("%s, %s", this.val, this.next);
			}
			return String.valueOf(this.val);
		}

	}

}
