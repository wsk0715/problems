package com.leetcode.solved.easy;

public class Solution_206 {

	// 206. Reverse Linked List - Easy
	// https://leetcode.com/problems/reverse-linked-list
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

			// Reverse Linked List 다른 풀이
			// 스택에 집어넣을 필요 없이, 노드를 탐색하는 동시에 참조(next)를 바꾸는 방법

			// 빈 입력값에 대한 예외처리
			if (head == null) {
				return null;
			}

			ListNode prev = null;  // 이전 노드를 가리키는 포인터
			ListNode cur = head;  // 현재 노드를 가리키는 포인터

			while (cur != null) {
				ListNode next = cur.next;  // a. 다음 노드를 불러와 임시로 저장한다.
				cur.next = prev;  // a-1. 이전 노드를 현재 탐색중인 노드의 새로운 다음 노드로 설정한다.
				prev = cur;  // a-2. 현재 탐색중인 노드를 이전 노드로 설정한다.
				cur = next;  // a-3. 미리 저장해둔 다음 노드를 탐색 중인 노드로 설정한다.
			}

			return prev;  // 뒤집힌 리스트의 새로운 head 반환
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
