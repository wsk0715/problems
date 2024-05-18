package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Solution_1439 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 뒤집기 - S5
	// https://www.acmicpc.net/problem/1439
	public static void main(String[] args) throws IOException {
		String s = readLine();

		// 문자열은 두 가지 유형이 있다: 0으로 이루어졌거나, 1로 이루어졌거나
		// 둘 중 갯수가 작은 쪽을 뒤집어야 최소가 된다.
		int count0s = s.startsWith("0") ? 1 : 0;
		int count1s = s.startsWith("1") ? 1 : 0;
		for (int i = 1; i < s.length(); i++) {
			char before = s.charAt(i - 1);
			char cur = s.charAt(i);
			if (cur != before) {
				if (cur == '0') {
					count0s += 1;
					continue;
				}
				count1s += 1;
			}
		}
		int r = Math.min(count0s, count1s);
		System.out.println(r);
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
