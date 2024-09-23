package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_9375 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 패션왕 신해빈 - S3
	// https://www.acmicpc.net/problem/9375
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			int count = readInt();
			Map<String, List<String>> hm = new HashMap<>();

			for (int j = 0; j < count; j++) {
				String[] cloth = readLine().split(" ");
				String name = cloth[0];
				String category = cloth[1];

				if (!hm.containsKey(category)) {
					hm.put(category, new ArrayList<>());
				}
				hm.get(category).add(name);
			}

			int result = 1;
			for (List<String> list : hm.values()) {
				result *= list.size() + 1;
			}
			result -= 1;
			write(result);
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
