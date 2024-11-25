package com.leetcode.util;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
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

