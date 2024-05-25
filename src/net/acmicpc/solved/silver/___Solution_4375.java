package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_4375 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 1 - S3
	// https://www.acmicpc.net/problem/4375
	public static void main(String[] args) throws IOException {

		// 모듈러 연산: (a * b + c) % d = ((a % d) * (b % d) + (c % d)) % d
		// -> (a * 10 + 1) % b = ((a % b) * (10 % b) + (1 % b)) % b
		String input;
		while ((input = readLine()) != null) {
			int n = Integer.parseInt(input);

			// n으로 나누어떨어지는 가장 큰 1로만 이루어진 수 구하기
			// 초기 수 = 1
			int m = 1;
			int l = 1;
			while (true) {
				if (m % n == 0) {
					write(l);
					break;
				}
				// 다음 수 = 1 * 10 + 1
				m = (m * 10 + 1) % n;
				l += 1;
			}
		}
		close();
	}
	/*
		두 번째 반복: m = 11 * 10 + 1 = 111
		두 번째 반복: m = (4 * 10 + 1) % 7 = 41 % 7 = 6

		첫 번째 식이 두 번째 식으로 변환되는 과정:
		m = 11 * 10 + 1 = 111
		-> (7+4) * 10 + 1 = 111
		-> ((7+4) * 10 + 1) % 7 = 111 % 7
		-> ((7 * 10) + (4 * 10) + 1) % 7 = 111 % 7
		-> ((7 * 10) % 7 + (4 * 10) % 7 + 1 % 7) % 7 = 111 % 7
		-> (((7 % 7) % 7 * (10 % 7)) % 7 + ((4 % 7) * (10 % 7)) % 7 + (1 % 7)) % 7 = 111 % 7
		-> ((0 * (10 % 7)) % 7 + ((4 % 7) * (10 % 7)) % 7 + (1 % 7)) % 7 = 111 % 7
		-> ((4 * 10) % 7 + (1 % 7)) % 7 = 111 % 7
		-> (4 * 10 + 1) % 7 = 111 % 7
		-> (4 * 10 + 1) % 7 = 15 & 6 => 6
		결과: m = (4 * 10 + 1) % 7 = 41 % 7 = 6
	 */


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
