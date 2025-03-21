package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _Solution_11286 {

	static int N, M;

	// 절댓값 힙 - S1
	// https://www.acmicpc.net/problem/11286
	public static void main(String[] args) throws IOException {
		// 절댓값으로 최소 힙을 구현하는 문제
		N = nextInt();

		Heap heap = new Heap();
		for (int i = 0; i < N; i++) {
			int n = nextInt();
			if (n == 0) {
				heap.remove();
			} else {
				heap.add(n);
			}
		}

		close();
	}

	static class Heap {

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int abs1 = Math.abs(o1);
				int abs2 = Math.abs(o2);

				if (abs1 == abs2) {
					return o1.compareTo(o2);
				}

				return Integer.compare(abs1, abs2);
			}
		});

		// 배열에 정수 x를 넣는다.
		void add(int x) {
			pq.add(x);
		}

		// 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 같은 경우에는 작은 수를 우선으로 제거한다.
		void remove() throws IOException {
			if (pq.isEmpty()) {
				write(0);
			} else {
				write(pq.poll());
			}
		}

	}

	// Libraries
	private static StringTokenizer readLine() throws IOException {
		return new StringTokenizer(br.readLine());
	}

	private static int nextInt() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = readLine();
		}
		return Integer.parseInt(st.nextToken());
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

}
