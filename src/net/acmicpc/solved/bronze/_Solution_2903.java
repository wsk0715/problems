package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _Solution_2903 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 중앙 이동 알고리즘 - B3
	// https://www.acmicpc.net/problem/2903
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// 각 변에 추가로 찍어야 하는 점의 개수:
		// 1 -> 2 -> 4 -> 8 -> ... -> 2^(n-1)
		// 점의 총 수는:
		// 한 변에 존재하는 점의 제곱
		// 0번 - 2, 1번 - 3(2 + 1), 2번 - 5(3 + 2), 3번 - 9(5 + 4) ..

		int count = 2;
		for (int i = 0; i < n; i++) {
			count += (int) Math.pow(2, i);
		}

		int r = (int) Math.pow(count, 2);
		write(r);

		close();
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine().trim());
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
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
