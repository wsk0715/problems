package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_10866 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 덱 - S4
	// https://www.acmicpc.net/problem/10866
	public static void main(String[] args) throws IOException {
		int n = readInt();

		Deque<Integer> ad = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String[] input = readLine().split(" ");
			String command = input[0];
			int X = 0;

			switch (command) {
				case "push_front":
					X = Integer.parseInt(input[1]);
					ad.push(X);
					break;
				case "push_back":
					X = Integer.parseInt(input[1]);
					ad.add(X);
					break;
				case "pop_front":
					if (ad.isEmpty()) {
						write(-1);
						break;
					}
					write(ad.removeFirst());
					break;
				case "pop_back":
					if (ad.isEmpty()) {
						write(-1);
						break;
					}
					write(ad.removeLast());
					break;
				case "size":
					write(ad.size());
					break;
				case "empty":
					write(ad.isEmpty() ? 1 : 0);
					break;
				case "front":
					if (ad.isEmpty()) {
						write(-1);
						break;
					}
					write(ad.getFirst());
					break;
				case "back":
					if (ad.isEmpty()) {
						write(-1);
						break;
					}
					write(ad.getLast());
					break;
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
