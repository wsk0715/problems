package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_9506 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 약수들의 합 - B1
	// https://www.acmicpc.net/problem/9506
	public static void main(String[] args) throws IOException {
		while (true) {
			int n = readInt();
			if (n == -1) {
				break;
			}

			ArrayList<Integer> al = new ArrayList<>();
			int sum = 0;
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					al.add(i);
					sum += i;
				}
			}

			String msg = String.valueOf(n);
			if (sum == n) {
				msg += " = ";
				msg += String.join(" + ", al.stream()
											.map(String::valueOf)
											.collect(Collectors.toList()));
			} else {
				msg += " is NOT perfect.";
			}
			write(msg);
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
