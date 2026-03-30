package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 최대 힙 - S2
 * https://www.acmicpc.net/problem/11279
 */
public class ____Solution_11279 {

	static int[] maxHeap;
	static int size;

	public static void main(String[] args) throws IOException {
		init();

		maxHeap = new int[100_001];
		size = 0;

		int N = nextInt();
		for (int i = 0; i < N; i++) {
			int v = nextInt();

			if (v == 0) {
				sb.append(remove()).append("\n");
			} else {
				add(v);
			}
		}

		System.out.print(sb);
		br.close();
	}

	// 삽입 연산 - 힙에 새롭게 값을 삽입 & 힙 연산 수행
	static void add(int value) {
		maxHeap[++size] = value;
		upHeapify(size);
	}

	// 힙 연산 (상향) - 부모와 나를 비교 후, 교환
	static void upHeapify(int i) {
		if (i <= 1) return;

		int parent = i / 2;
		if (maxHeap[parent] < maxHeap[i]) {
			swap(i, parent);
			upHeapify(parent);
		}
	}

	// 삭제 연산 - 맨 앞에 있는 값(루트)을 삭제하며 그 값을 반환 & 힙 연산 수행
	static int remove() {
		if (size == 0) return 0;

		int root = maxHeap[1];

		maxHeap[1] = maxHeap[size--];
		downHeapify(1);

		return root;
	}

	// 힙 연산 (하향) - 좌,우 자식과 나를 비교 후, 교환
	static void downHeapify(int i) {
		int left = i * 2;
		int right = i * 2 + 1;

		int target = i;
		if (left <= size && maxHeap[left] > maxHeap[target]) target = left;
		if (right <= size && maxHeap[right] > maxHeap[target]) target = right;

		if (target != i) {
			swap(i, target);
			downHeapify(target);
		}
	}

	// 스왑 연산 - a와 b를 교환
	static void swap(int a, int b) {
		int tmp = maxHeap[a];
		maxHeap[a] = maxHeap[b];
		maxHeap[b] = tmp;
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
