package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_10431 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 줄세우기 - S5
	// https://www.acmicpc.net/problem/10431
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			String[] input = readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int[] arr = Arrays.stream(Arrays.copyOfRange(input, 1, input.length))
							  .mapToInt(Integer::parseInt)
							  .toArray();
			solve(x, arr);
		}

		close();
	}

	private static void solve(int x, int[] arr) throws IOException {
		int result = 0;

		ArrayList<Integer> seq = new ArrayList<>();
		l1:
		for (int i = 0; i < arr.length; i++) {
			int e = arr[i];
			if (seq.isEmpty()) {
				seq.add(e);
				continue;
			}
			for (int j = 0; j < seq.size(); j++) {
				if (e < seq.get(j)) {
					result += seq.size() - j;
					seq.add(j, e);
					continue l1;
				}
			}
			seq.add(e);
		}

		String str = String.format("%s %s", x, result);
		write(str);
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
