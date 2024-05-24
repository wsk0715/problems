package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_10610 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 30 - S4
	// https://www.acmicpc.net/problem/10610
	public static void main(String[] args) throws IOException {
		String[] numbers = readLine().split("");

		// 숫자를 섞어 30의 배수를 만들려면
		// 1. 하나 이상의 0이 포함되어야 한다.
		boolean condition = false;
		for (String number : numbers) {
			if (number.equals("0")) {
				condition = true;
				break;
			}
		}
		// 2. 모든 자릿수를 더한 값이 3의 배수여야 한다.
		if (condition) {
			int sum = Arrays.stream(numbers)
							.mapToInt(Integer::parseInt)
							.sum();
			if (sum % 3 != 0) {  // sum이 0인 경우는 없다.
				condition = false;
			}
		}
		if (condition) {
			write(calc(numbers));
		} else {
			write(-1);
		}
		close();
	}

	private static String calc(String[] arr) {
		StringBuilder sb = new StringBuilder();
		// 1과 2 조건을 만족하는 수만 통과시켰으므로 가장 큰 수부터 나열하면 될 것
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}

		return sb.toString();
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
