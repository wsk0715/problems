package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ___Solution_1991 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 트리 순회 - S1
	// https://www.acmicpc.net/problem/1991
	public static void main(String[] args) throws IOException {
		int n = readInt();

		Tree tree = new Tree();
		for (int i = 0; i < n; i++) {
			String[] line = readLine().split(" ");
			String current = line[0];
			String left = line[1];
			String right = line[2];

			tree.add(current, left, right);
		}

		Node root = tree.hm.get("A");
		tree.preorder(root);
		bw.newLine();
		tree.inorder(root);
		bw.newLine();
		tree.postorder(root);
		bw.newLine();

		close();
	}

	static class Tree {

		Map<String, Node> hm = new HashMap<>();

		void add(String parent, String left, String right) {
			hm.putIfAbsent(parent, new Node(parent));
			Node parentNode = hm.get(parent);

			if (!left.equals(".")) {
				hm.putIfAbsent(left, new Node(left));
				parentNode.left = hm.get(left);
			}
			if (!right.equals(".")) {
				hm.putIfAbsent(right, new Node(right));
				parentNode.right = hm.get(right);
			}
		}

		// a. 전위 순회, 루트 - 좌측 자식 - 우측 자식
		void preorder(Node node) throws IOException {
			if (node == null) {
				return;
			}
			bw.write(node.name);   // a-1. 현재 노드 출력
			preorder(node.left);   // a-2. 좌측 자식 노드 출력
			preorder(node.right);  // a-3. 우측 자식 노드 출력
		}

		// b. 중위 순회, 좌측 자식 - 루트 - 우측 자식
		void inorder(Node node) throws IOException {
			if (node == null) {
				return;
			}
			inorder(node.left);   // b-1. 좌측 자식 노드 출력
			bw.write(node.name);  // b-2. 현재 노드 출력
			inorder(node.right);  // b-3. 우측 자식 노드 출력
		}

		// c. 후위 순회, 좌측 자식 - 우측 자식 - 루트
		void postorder(Node node) throws IOException {
			if (node == null) {
				return;
			}
			postorder(node.left);   // c-1. 좌측 자식 노드 출력
			postorder(node.right);  // c-2. 우측 자식 노드 출력
			bw.write(node.name);    // c-3. 현재 노드 출력
		}

	}

	static class Node {

		String name;
		Node left;
		Node right;

		Node(String name) {
			this.name = name;
		}

	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	private static int[] readIntegers() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[st.countTokens()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		return arr;
	}

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

}
