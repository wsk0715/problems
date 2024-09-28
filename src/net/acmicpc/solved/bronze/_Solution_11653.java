package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _Solution_11653 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 소인수분해 - B1
	// https://www.acmicpc.net/problem/11653
	public static void main(String[] args) throws IOException {
		int n = readInt();

		StringBuilder sb = new StringBuilder();
		if (n == 1) {
			close();
			return;
		}

		// a. 2로 나누기
		while (n % 2 == 0) {
			sb.append(2).append("\n");
			n /= 2;
		}

		// b. 3부터 루트 n까지, 홀수로 나누기
		for (int i = 3; i * i <= n; i += 2) {
			while (n % i == 0) {
				sb.append(i).append("\n");
				n /= i;
			}
		}

		// c. 마지막에 남은 수 출력
		if (n > 2) {
			sb.append(n).append("\n");
		}

		write(sb);

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
