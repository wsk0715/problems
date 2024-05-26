package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _Solution_11005 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 진법 변환 2 - B1
	// https://www.acmicpc.net/problem/11005
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();
		int n = input[0];
		int radix = input[1];

		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			int mod = n % radix;
			n /= radix;

			if (mod + '0' > '9') {
				sb.append((char) (mod - 10 + 'A'));
				continue;
			}
			sb.append(mod);
		}
		write(sb.reverse());
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
