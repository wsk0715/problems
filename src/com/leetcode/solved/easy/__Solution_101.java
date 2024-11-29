package com.leetcode.solved.easy;

import com.leetcode.util.TreeNode;

public class __Solution_101 {

	// 101. Symmetric Tree - Easy
	// https://leetcode.com/problems/symmetric-tree
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
		System.out.println(sol.isSymmetric(root));
	}

	static class Solution {

		public boolean isSymmetric(TreeNode root) {
			// 1. 이진 트리 root가 좌우 대칭인지 판별하라.
			// 2. 노드의 수는 1 이상 1000 이하이다.
			// 2-1. 노드의 값은 -100 이상 100 이하이다.

			if (root == null) {
				return true;
			}
			return isMirror(root.left, root.right);
		}

		private boolean isMirror(TreeNode t1, TreeNode t2) {
			if (t1 == null && t2 == null) {
				return true;
			}
			if (t1 == null || t2 == null) {
				return false;
			}
			return (t1.val == t2.val)
				   && isMirror(t1.left, t2.right)
				   && isMirror(t1.right, t2.left);
		}

	}

}
