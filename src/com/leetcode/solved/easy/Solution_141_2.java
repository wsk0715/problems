package com.leetcode.solved.easy;

public class Solution_141_2 {

	// 141. Linked List Cycle - Easy
	// https://leetcode.com/problems/linked-list-cycle
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(0, node1);
		ListNode node3 = new ListNode(2, node2);
		ListNode head = new ListNode(3, node3);
		node1.next = node3;
		System.out.println(sol.hasCycle(head));
	}

	static class Solution {

		public boolean hasCycle(ListNode head) {
			// 1. linked list의 맨 앞(head)인 변수 head가 주어진다.
			// 2. head 내부에서 순환이 이루어지는지 판별하라.
			// 2-1. head 내부에서 next 포인터를 이용해 자신에게 되돌아올 수 있으면 연결 리스트가 순환한다고 정의한다.
			// 3. 리스트에 포함된 노드의 갯수는 0 이상, 10^4 이하이다.
			// 3-1. 노드의 값의 범위는 -10^5 이상, 10^5 이하이다.
			// + 공간 복잡도가 O(1)이 되도록 해결할 수 있는가?

			// 예외처리; head가 null인 경우
			if (head == null) {
				return false;
			}

			// Linked List Cycle 다른 풀이
			// 서로 다른 두 포인터 slow, fast를 설정한다.
			// slow는 한 칸씩, fast는 두 칸씩 이동한다.
			// slow와 fast가 동일한 노드에서 만나게 되면 순환하는 연결 리스트이다.
			// slow, fast 두 개의 변수만 사용하기 때문에 공간 복잡도는 O(1)로 일정하다.

			// 두 개의 포인터 설정
			ListNode slow = head;
			ListNode fast = head;

			while (fast != null && fast.next != null) {
				slow = slow.next;  // 한 노드씩 이동하는 slow
				fast = fast.next.next;  // 두 노드씩 이동하는 fast

				if (slow == fast) {  // 두 포인터가 만난다면,
					return true;  // 사이클이 존재한다.
				}
			}

			return false;  // 두 포인터가 만나지 않고 종료된 경우
		}

	}

	static class ListNode {

		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		ListNode(int x, ListNode node) {
			val = x;
			next = node;
		}

	}

}
