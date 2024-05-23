package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Solution_1764 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 듣보잡 - S4
	// https://www.acmicpc.net/problem/1764
	public static void main(String[] args) throws IOException {
		int[] inputs = readIntegers();
		int n = inputs[0];
		int m = inputs[1];

		HashSet<String> list = new HashSet<>();
		for (int i = 0; i < n; i++) {
			list.add(readLine());
		}
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String s = readLine();
			if (list.contains(s)) {
				result.add(s);
			}
		}
		System.out.println(result.size());
		Collections.sort(result);
		result.forEach(System.out::println);

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

	private static void write(String s) throws IOException {
		bw.write(s);
		bw.newLine();
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		br.close();
	}

}
