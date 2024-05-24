package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _Solution_10816 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 숫자 카드 2 - S4
	// https://www.acmicpc.net/problem/10816
	public static void main(String[] args) throws IOException {
		// 보유 카드
		int n = readInt();
		int[] own = readIntegers();

		int[] cards = new int[20_000_001];
		for (int i = 0; i < n; i++) {
			cards[own[i] + 10_000_000] += 1;
		}

		// 카드 찾기
		int m = readInt();
		int[] targets = readIntegers();

		String[] result = new String[m];
		for (int i = 0; i < m; i++) {
			result[i] = String.valueOf(cards[targets[i] + 10_000_000]);
		}
		write(String.join(" ", result));

		close();
	}

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
