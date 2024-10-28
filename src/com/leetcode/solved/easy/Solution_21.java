package com.leetcode.solved.easy;

public class Solution_21 {

	// 21. Merge Two Sorted Lists - Easy
	// https://leetcode.com/problems/merge-two-sorted-lists
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		System.out.println(sol.mergeTwoLists(list1, list2));
	}

	static class Solution {

		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			// 1. 두 개의 정렬된 연결 리스트 list1, list2가 주어진다.
			// 2. 두 리스트를 하나의 정렬된 리스트로 합쳐야 한다.
			// 3. 합쳐진 연결 리스트의 head를 반환하라.
			// 4. 각 리스트의 노드의 갯수는 0개 이상, 50개 이하이다.
			// 4-1. 각 노드의 값은 -100 이상, 100 이하이다.
			// 4-2. list1, list2는 모두 오름차순(non-decreasing)으로 정렬되어있다.

			// 예외 처리
			if (list1 == null) {
				if (list2 == null) {
					return null;
				}
				return list2;
			} else if (list2 == null) {
				return list1;
			}

			// a. 두 리스트에서 각각 포인터를 설정한다.
			ListNode p1 = list1;
			ListNode p2 = list2;

			// b. 결과를 담을 연결 리스트와, 포인터를 생성한다.
			ListNode result = new ListNode();
			ListNode cur = result;

			// c. 결과 계산
			while (p1 != null && p2 != null) {
				if (p1.val < p2.val) {
					cur.next = p1;
					p1 = p1.next;
				} else {
					cur.next = p2;
					p2 = p2.next;
				}

				cur = cur.next;
			}

			// d. 둘 중 남은 노드를 연결 리스트에 병합
			if (p1 == null) {
				cur.next = p2;
			} else if (p2 == null) {
				cur.next = p1;
			}

			return result.next;
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
