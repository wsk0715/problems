package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_11050 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 이항 계수 1 - B1
	// https://www.acmicpc.net/problem/11050
	public static void main(String[] args) throws IOException {
		int[] inputs = readIntegers();
		int n = inputs[0];
		int k = inputs[1];

		// 이항 계수: (n / k)와 같이 나타낸다.
		// n개의 원소 중 k개의 원소를 선택하는 방법의 수(조합)를 의미한다.
		// 조합 -> (n! / (k! * (n - k)!))

		int r = facto(n) / (facto(k) * facto(n - k));
		write(String.valueOf(r));

		close();
	}

	public static int facto(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		return n * facto(n - 1);
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
