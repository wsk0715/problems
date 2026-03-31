package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 트리의 순회 - G1
 * https://www.acmicpc.net/problem/2263
 */
public class ____Solution_2263 {

	static int[] inOrder;
	static int[] postOrder;
	static int[] pos;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt();

		// 중위 순회 - LVR
		inOrder = new int[N];
		for (int i = 0; i < N; i++) {
			inOrder[i] = nextInt();
		}
		// 후위 순회 - LRV
		postOrder = new int[N];
		for (int i = 0; i < N; i++) {
			postOrder[i] = nextInt();
		}

		pos = new int[N + 1];
		for (int i = 0; i < N; i++) {
			pos[inOrder[i]] = i;  // 각 inorder 값의 인덱스 저장
		}

		calc(0, N - 1, 0, N - 1);

		System.out.print(sb);
		br.close();
	}

	static void calc(int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) return;

		// 1. postorder의 끝은 항상 루트
		int root = postOrder[postEnd];
		sb.append(root).append(" ");  // 전위 순회

		// 2. inorder의 중간(루트)을 기준으로 분할
		int rootIdx = pos[root];
		int leftSize = rootIdx - inStart;

		// 3. 왼쪽, 오른쪽 분할 & 탐색
		// 좌측 서브트리
		// inorder: start ~ 루트 직전
		// postorder: start ~ 시작점 + 좌측범위 - 1
		calc(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);

		// 우측 서브트리
		// inorder: 루트 다음 ~ end
		// postorder: start + 좌측범위 ~ 루트 직전
		calc(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
	}


	// Libraries
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;

	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null) {
				return null;
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
