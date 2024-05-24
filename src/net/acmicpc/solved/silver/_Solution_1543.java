package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Solution_1543 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 문서 검색 - S5
	// https://www.acmicpc.net/problem/1543
	public static void main(String[] args) throws IOException {
		String s = readLine();
		String target = readLine();

		int count = 0;
		int idx = 0;
		while (idx < s.length()) {
			boolean con = s.startsWith(target, idx);
			if (con) {
				idx += target.length();
				count += 1;
				continue;
			}
			idx += 1;
		}
		System.out.println(count);
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine()
									   .trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}
