package com.leetcode.solved.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution_141 {

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

			// a. 노드를 탐색하며 노드의 주소값을 HashSet과 비교한다.
			// 종료조건; false - 더 이상 next가 존재하지 않을 때.
			// 종료조건; true - 해시에 이미 노드 주소값이 존재할 때.
			Set<ListNode> hs = new HashSet<>();
			ListNode p = head;
			while (p.next != null) {
				if (hs.contains(p)) {  // HashSet에 이미 해당 노드의 주소가 존재하는 경우.
					return true;
				}
				hs.add(p);
				p = p.next;
			}

			return false;  // 더 이상 next가 존재하지 않는 경우
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
