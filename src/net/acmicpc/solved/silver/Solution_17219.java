package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_17219 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 비밀번호 찾기 - S4
	// https://www.acmicpc.net/problem/17219
	public static void main(String[] args) throws IOException {
		int[] in = readIntegers();
		int n = in[0];
		int m = in[1];

		Map<String, String> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] input = readLine().split(" ");
			String site = input[0];
			String pw = input[1];

			hm.put(site, pw);
		}

		for (int i = 0; i < m; i++) {
			String target = readLine();
			String result = hm.get(target);
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
