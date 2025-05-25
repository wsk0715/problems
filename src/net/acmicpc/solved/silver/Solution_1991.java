package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution_1991 {

	static int N, M;
	static Map<String, Node> nodes = new HashMap<>();

	// 트리 순회 - S1
	// https://www.acmicpc.net/problem/1991
	public static void main(String[] args) throws IOException {
		// 1. 입력 받기
		N = Integer.parseInt(br.readLine());

		// 1-1. 모든 연결 정보 입력
		for (int i = 0; i < N; i++) {
			String[] _input = br.readLine().split(" ");
			String parent = _input[0];
			String left = _input[1].equals(".") ? null : _input[1];
			String right = _input[2].equals(".") ? null : _input[2];

			// 부모 노드 정보 삽입
			nodes.putIfAbsent(parent, new Node(parent));
			Node parentNode = nodes.get(parent);

			// 왼쪽 자식 노드 정보 삽입
			if (left != null) {
				nodes.putIfAbsent(left, new Node(left));
				parentNode.left = nodes.get(left);
			}

			// 오른쪽 자식 노드 정보 삽입
			if (right != null) {
				nodes.putIfAbsent(right, new Node(right));
				parentNode.right = nodes.get(right);
			}
		}

		Node root = nodes.get("A");  // 루트 노드는 항상 "A"

		// 2. 트리 순회
		preorder(root);
		bw.newLine();
		inorder(root);
		bw.newLine();
		postorder(root);
		bw.newLine();

		close();
	}

	static void preorder(Node node) throws IOException {
		// 종료 조건 - 현재 탐색하려는 노드가 null일 때
		if (node == null) {
			return;
		}

		// 전위 순회
		// 출력 순서: 자기자신 -> 왼쪽 자식 -> 오른쪽 자식
		bw.write(node.value);
		preorder(node.left);
		preorder(node.right);
	}


	static void inorder(Node node) throws IOException {
		// 종료 조건 - 현재 탐색하려는 노드가 null일 때
		if (node == null) {
			return;
		}

		// 중위 순회
		// 출력 순서: 왼쪽 자식 -> 자기자신 -> 오른쪽 자식
		inorder(node.left);
		bw.write(node.value);
		inorder(node.right);
	}

	static void postorder(Node node) throws IOException {
		// 종료 조건 - 현재 탐색하려는 노드가 null일 때
		if (node == null) {
			return;
		}

		// 후위 순회
		// 출력 순서: 왼쪽 자식 -> 오른쪽 자식 -> 루트
		postorder(node.left);
		postorder(node.right);
		bw.write(node.value);
	}

	static class Node {

		String value;
		Node left;
		Node right;

		public Node(String value) {
			this.value = value;
		}

	}


	// Libraries
	private static <T> void write(T value) throws IOException {
		String s = String.valueOf(value);
		bw.write(s);
		bw.newLine();
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		br.close();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

}
