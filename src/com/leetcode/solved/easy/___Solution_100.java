package com.leetcode.solved.easy;

import com.leetcode.util.TreeNode;

public class ___Solution_100 {

	// 100. Same Tree - Easy
	// https://leetcode.com/problems/same-tree
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		System.out.println(sol.isSameTree(p, q));
	}

	static class Solution {

		public boolean isSameTree(TreeNode p, TreeNode q) {
			// 1. 두 이진 트리 p, q가 동일한지 판별하라.
			// 1-1. 두 이진 트리의 구조가 동일하고, 각 노드의 값이 같을 때 동일하다고 한다.

			// 노드의 갯수는 0 이상 100 이하이다.
			// -10^4 <= node.val <= 10^4


			// 둘 모두 null인 경우
			if (p == null && q == null) {
				return true;
			}

			// 하나만 null이거나, 값이 다를 경우
			if (p == null || q == null || p.val != q.val) {
				return false;
			}

			// 왼쪽과 오른쪽 서브트리를 재귀적으로 비교
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}

	}

}
