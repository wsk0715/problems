package com.leetcode.solved.easy;

import com.leetcode.util.TreeNode;

public class ___Solution_543 {

	// 543. Diameter of Binary Tree - Easy
	// https://leetcode.com/problems/diameter-of-binary-tree
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
		System.out.println(sol.diameterOfBinaryTree(root));
	}

	static class Solution {

		int maxDiameter = 0;

		public int diameterOfBinaryTree(TreeNode root) {
			// 1. 이진 트리의 root가 주어진다. 이 때 root의 diameter를 반환하라.
			// 1-1. diameter란 트리에서 가장 긴 경로(한 노드에서 다른 한 노드로 향하는 경로)의 길이이다.
			// 1-2. 이 때 경로는 root를 지날 수도, 지나지 않을 수도 있다.
			// 1-3. 경로의 길이는 두 노드 사이의 간선(edge)의 갯수이다.
			// 2. 노드의 갯수는 1 이상, 10^4 이하이다.
			// 2-1. 노드의 val 값의 범위는 -100 이상, 100 이하이다.

			depth(root);
			return maxDiameter;
		}

		public int depth(TreeNode node) {
			// 끝 노드에 도달한 경우
			if (node == null) {
				return 0;
			}

			// 재귀 함수를 이용해 왼쪽, 오른쪽 노드의 깊이 탐색
			int left = depth(node.left);
			int right = depth(node.right);

			// 전역 변수로 선언된 최대 깊이 갱신
			maxDiameter = Math.max(maxDiameter, left + right);

			// 재귀 함수의 반환값, 지금까지의 최대 깊이에 자기자신을 더해 반환
			return Math.max(left, right) + 1;
		}

	}

}
