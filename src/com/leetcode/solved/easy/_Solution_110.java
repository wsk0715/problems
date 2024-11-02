package com.leetcode.solved.easy;

public class _Solution_110 {

	// 110. Balanced Binary Tree - Easy
	// https://leetcode.com/problems/balanced-binary-tree
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		TreeNode root = new TreeNode(3, new TreeNode(3, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(sol.isBalanced(root));
	}

	static class Solution {

		public boolean isBalanced(TreeNode root) {
			// 1. 이진 트리(binary tree) root가 주어진다.
			// 2. root가 height-balanced인지 판별하라.
			// 2-1. height-balanced(높이 균형)란, 모든 노드에 대해 두 하위 노드의 높이 차이가 1 이하인 경우이다.
			// 3. 트리의 노드의 갯수는 0개 이상, 5000개 이하이다.
			// 3-1. 트리의 노드가 가질 수 있는 값은 -10^4 이상, 10^4 이하이다.

			return checkHeight(root) != -1;
		}

		private int checkHeight(TreeNode node) {
			if (node == null) {
				return 0;  // 빈 노드의 높이는 0
			}

			// a. 좌측 서브 트리 높이 계산
			int lHeight = checkHeight(node.left);
			if (lHeight == -1) {
				return -1;  // 좌측 서브 트리 균형이 맞지 않으면 바로 -1 반환
			}

			// b. 우측 서브 트리 높이 계산
			int rHeight = checkHeight(node.right);
			if (rHeight == -1) {
				return -1;  // 우측 서브 트리 균형이 맞지 않으면 바로 -1 반환
			}

			// c. 현재 노드의 높이 차이 계산하여 균형을 이루지 않으면(높이 차가 1보다 크면) -1 반환
			if (Math.abs(lHeight - rHeight) > 1) {
				return -1;
			}

			// 현재 노드의 높이 반환
			return Math.max(lHeight, rHeight) + 1;
		}

	}

	public static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

	}

}
