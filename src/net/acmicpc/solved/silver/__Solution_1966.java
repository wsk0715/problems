package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class __Solution_1966 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 프린터 큐 - S3
	// https://www.acmicpc.net/problem/1966
	public static void main(String[] args) throws IOException {
		int t = readInt();

		for (int i = 0; i < t; i++) {
			int[] line = readIntegers();
			int n = line[0];
			int m = line[1];

			Queue<int[]> queue = new LinkedList<>();  // 문서 순서와 중요도를 함께 담을 큐
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());  // 문서의 중요도를 담을 우선순위 큐(오름차순)

			int[] docs = readIntegers();
			for (int j = 0; j < n; j++) {
				int p = docs[j];  // 현재 문서의 중요도
				queue.add(new int[]{j, p});  // 큐에 문서의 순서와 중요도 저장
				heap.add(p);  // 우선 순위 큐에 중요도 저장
			}

			int count = 0;
			while (!queue.isEmpty()) {
				int[] current = queue.poll();  // 큐에서 맨 앞 문서 꺼내기

				if (current[1] == heap.peek()) {  // 현재 문서의 중요도가 가장 높다면
					// 현재 문서 인쇄
					heap.poll();
					count += 1;

					if (current[0] == m) {  // 인쇄된 문서가 원하는 문서라면
						// 순서 출력 후 종료
						write(count);
						break;
					}
				} else {
					queue.add(current);  // 큐의 맨 뒤에 삽입

				}

			}

		}

		close();
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine()
								  .trim());
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(br.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
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
