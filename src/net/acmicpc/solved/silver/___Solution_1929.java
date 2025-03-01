package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ___Solution_1929 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 소수 구하기 - S3
	// https://www.acmicpc.net/problem/1929
	public static void main(String[] args) throws IOException {
		int[] params = readIntegers();
		int M = params[0];
		int N = params[1];

		List<Integer> al = new ArrayList<>();
		for (int i = M; i <= N; i++) {
			if (isPrime(i)) {
				al.add(i);
			}
		}

		for (Integer i : al) {
			write(i);
		}

		close();
	}

	static boolean isPrime(int n) {
		if (n < 2) {  // 0, 1은 소수가 아님
			return false;
		}
		if (n == 2) {  // 2는 소수
			return true;
		}
		if (n % 2 == 0) {  // 2를 제외한 모든 짝수는 소수가 아님
			return false;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	private static int[] readIntegers() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[st.countTokens()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		return arr;
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
