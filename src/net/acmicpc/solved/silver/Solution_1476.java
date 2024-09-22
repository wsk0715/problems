package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_1476 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 날짜 계산 - S5
	// https://www.acmicpc.net/problem/1476
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();

		int result = 1;
		int[] arr = {1, 1, 1};  // 최대 15, 28, 19
		while (true) {
			if (input[0] == arr[0] && input[1] == arr[1] && input[2] == arr[2]) {
				write(result);
				break;
			}

			calc(arr);
			result += 1;
		}

		close();
	}

	private static void calc(int[] arr) {
		if (arr[0] == 15) {
			arr[0] = 1;
		} else {
			arr[0] += 1;
		}

		if (arr[1] == 28) {
			arr[1] = 1;
		} else {
			arr[1] += 1;
		}

		if (arr[2] == 19) {
			arr[2] = 1;
		} else {
			arr[2] += 1;
		}
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
