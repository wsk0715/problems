package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ___Solution_1927 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 최소 힙 - S2
	// https://www.acmicpc.net/problem/1927
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		int n = readInt();
		for (int i = 0; i < n; i++) {
			int minHeap = readInt();

			if (minHeap == 0) {
				int val = 0;

				if (!heap.isEmpty()) {
					val = heap.poll();
				}

				write(val);
			} else {
				heap.add(minHeap);
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
