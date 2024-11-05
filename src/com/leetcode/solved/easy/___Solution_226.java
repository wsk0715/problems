package com.leetcode.solved.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ___Solution_226 {

	// 226. Invert Binary Tree - Easy
	// https://leetcode.com/problems/invert-binary-tree
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(7), new TreeNode(9)));
		System.out.println(sol.invertTree(root));
	}

	static class Solution {

		public TreeNode invertTree(TreeNode root) {
			// 1. 이진 트리 root가 주어진다.
			// 2. root를 반전(invert)한 후, root를 반환하라.
			// 3. 트리의 노드 갯수는 0 이상, 100 이하이다.
			// 3-1. 각 노드의 val은 -100 이상, 100 이하이다.

			// 반전 대상(하위 노드가 존재하는) 노드를 전부 큐에 삽입, 탐색
			// a. 첫 번째 노드부터 탐색 시작
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);

			// b. 탐색 시작
			while (!queue.isEmpty()) {

				// b-1. 탐색 대상 노드의 좌, 우 노드 큐에 삽입
				TreeNode current = queue.poll();
				if (current == null) {  // 탐색 대상 노드가 존재하지 않는다면(이전 노드가 끝 노드라면)
					continue;  // 다음 반복 진행
				}

				queue.offer(current.left);
				queue.offer(current.right);

				// b-2. 탐색 대상 노드의 좌, 우 노드 반전
				TreeNode temp = current.left;
				current.left = current.right;
				current.right = temp;
			}

			return root;
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
