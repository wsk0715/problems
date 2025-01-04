package com.leetcode.solved.easy;

import com.leetcode.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class ___Solution_104 {

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


			if (root == null) {
				return 0;
			}

			// dfs
			Queue<TreeNode> queue = new LinkedList<>();
			// 첫 노드 탐색 처리
			queue.add(root);
			int depth = 0;

			while (!queue.isEmpty()) {
				int levelSize = queue.size();

				for (int i = 0; i < levelSize; i++) {
					TreeNode current = queue.poll();

					if (current.left != null) {
						queue.add(current.left);
					}

					if (current.right != null) {
						queue.add(current.right);
					}
				}
				depth += 1; // 현재 레벨을 모두 탐색했으므로 깊이 증가
			}

			return depth;
		}

	}

}
