package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_11723 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 집합 - S5
	// https://www.acmicpc.net/problem/11723
	public static void main(String[] args) throws IOException {
		int n = readInt();

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String[] input = readLine().split(" ");
			String command = input[0];
			int x = -1;

			if (input.length > 1) {
				x = Integer.parseInt(input[1]);
			}

			switch (command) {
				case "add":
					set.add(x);
					break;
				case "remove":
					set.remove(x);
					break;
				case "check":
					if (set.contains(x)) {
						write(1);
					} else {
						write(0);
					}
					break;
				case "toggle":
					if (set.contains(x)) {
						set.remove(x);
					} else {
						set.add(x);
					}
					break;
				case "all":
					set.clear();
					for (int j = 1; j <= 20; j++) {
						set.add(j);
					}
					break;
				case "empty":
					set.clear();
					break;
				default:
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
