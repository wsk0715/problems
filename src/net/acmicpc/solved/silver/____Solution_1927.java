package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 최소 힙 - S2
 * https://www.acmicpc.net/problem/1927
 */
public class ____Solution_1927 {

	static int[] minHeap;
	static int size;

	public static void main(String[] args) throws IOException {
		init();

		minHeap = new int[100_001];
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
		// 힙의 맨 끝에 요소 추가 & 힙 연산
		minHeap[++size] = value;
		upHeapify(size);  // 맨 마지막 위치(size)에서부터 힙 연산 수행
	}

	// 힙 연산 (상향) - 부모와 나를 비교 후, 교환
	static void upHeapify(int i) {
		// 루트에 도달한 경우
		if (i <= 1) return;

		// 내가 부모보다 작은(우선순위가 높은) 경우, 교환 & 재귀 호출
		int parent = i / 2;
		if (minHeap[parent] > minHeap[i]) {
			swap(i, parent);
			upHeapify(parent);
		}
	}

	// 삭제 연산 - 맨 앞에 있는 값(루트)을 삭제하며 그 값을 반환 & 힙 연산 수행
	static int remove() {
		// 힙이 빈 경우
		if (size == 0) return 0;

		int root = minHeap[1];  // 현재 힙에서 가장 앞에 있는 값을 미리 저장

		// 힙의 맨 끝 요소를 루트로 설정 & 힙 연산
		minHeap[1] = minHeap[size--];  // (여기서 맨 뒤 요소는 논리적으로 제거됨 = 인덱스 범위 밖에 위치)
		downHeapify(1);  // 새로운 루트(1)에서부터 힙 연산 수행

		return root;  // 미리 저장해둔 값 반환
	}

	// 힙 연산 (하향) - 좌,우 자식과 나를 비교 후, 교환
	static void downHeapify(int i) {
		int left = i * 2;
		int right = i * 2 + 1;

		// 좌,우 자식 노드가 나보다 작은지(우선순위가 높은지) 확인
		int target = i;  // 교환 대상; (초기값 = 자기자신)
		if (left <= size && minHeap[left] < minHeap[target]) target = left;
		if (right <= size && minHeap[right] < minHeap[target]) target = right;

		// 교환 대상(우선순위가 높은 자식)이 있는 경우, 교환 & 재귀 호출
		if (target != i) {
			swap(i, target);
			downHeapify(target);
		}
	}

	// 스왑 연산 - a와 b를 교환
	static void swap(int a, int b) {
		int tmp = minHeap[a];
		minHeap[a] = minHeap[b];
		minHeap[b] = tmp;
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
