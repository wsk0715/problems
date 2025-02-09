package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _Solution_1629 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 곱셈 - S1
	// https://www.acmicpc.net/problem/1629
	public static void main(String[] args) throws IOException {
		int[] numbers = readIntegers();

		long A = numbers[0];
		long B = numbers[1];
		long C = numbers[2];

		write(modPow(A, B, C));

		close();
	}

	private static long modPow(long a, long b, long mod) {
		// 지수가 0인 경우
		if (b == 0) {
			return 1;  // a^0 = 1
		}

		// 1. b가 짝수일 경우
		long half = modPow(a, b / 2, mod);
		long result = (half * half) % mod;  // a^b = (a^(b/2))^2

		// 2. b가 홀수일 경우
		if (b % 2 == 1) {
			result = (result * (a % mod)) % mod;  // a^b = a * a^(b-1)
		}

		return result;
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
