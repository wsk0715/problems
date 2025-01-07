package com.leetcode.solved.easy;

import com.leetcode.util.TreeNode;

public class ___Solution_572 {

	// 572. Subtree of Another Tree - Easy
	// https://leetcode.com/problems/subtree-of-another-tree
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
		TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
		System.out.println(sol.isSubtree(root, subRoot));
	}

	static class Solution {

		public boolean isSubtree(TreeNode root, TreeNode subRoot) {
			// 1. 이진 트리 subRoot가 이진 트리 root의 서브트리인지 확인하라.

			// root의 노드 갯수는 1 이상, 2000 이하이다.
			// subRoot의 노드 갯수는 1 이상, 1000 이하이다.
			// -10^4 <= root.val, subRoot.val <= 10^4


			if (root == null) {
				return false;
			}

			// 현재 노드에 대해 subRoot와 동일한 트리인지 확인
			if (isSameTree(root, subRoot)) {
				return true;
			}

			// 왼쪽 또는 오른쪽 서브트리에서 subRoot를 찾음
			return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
		}

		private boolean isSameTree(TreeNode p, TreeNode q) {
			// a. 두 트리가 모두 null인 경우 - 동일한 트리
			if (p == null && q == null) {
				return true;
			}

			// b. 둘 중 하나만 null인 경우 - 다른 트리
			if (p == null || q == null) {
				return false;
			}

			// c. 현재 노드 값이 다른 경우 - 다른 트리
			if (p.val != q.val) {
				return false;
			}

			// d. 왼쪽과 오른쪽 자식도 동일한지 확인
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}

	}

}
