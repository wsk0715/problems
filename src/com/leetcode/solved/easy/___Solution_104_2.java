package com.leetcode.solved.easy;

import com.leetcode.util.TreeNode;

public class ___Solution_104_2 {

	// 104. Maximum depth of Binary Tree - Easy
	// https://leetcode.com/problems/maximum-depth-of-binary-tree
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(sol.maxDepth(root));
	}

	static class Solution {

		public int maxDepth(TreeNode root) {
			// 1. 이진트리 root의 최대 깊이를 반환하라.

			// 노드의 갯수는 0 이상, 10^4 이하이다.
			// -100 <= node.val <= 100


			// 재귀 사용
			if (root == null) {
				return 0;
			}

			int left = maxDepth(root.left);
			int right = maxDepth(root.right);

			return Math.max(left, right) + 1;
		}

	}

}
