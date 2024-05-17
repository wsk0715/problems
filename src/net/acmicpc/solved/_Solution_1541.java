package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _Solution_1541 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 잃어버린 괄호 - S2
	// https://www.acmicpc.net/problem/1541
	private static ArrayList<String> numbers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		String input = readLine();

		// 값을 최소로 하려면? -> (-) 부호를 크게
		// (-) 부호가 처음 등장하면 이후 모든 (+) 값에 대해 괄호를 친다.
		parseNumber(input);

		int r = 0;
		boolean minus = false;
		for (String number : numbers) {
			if (number.startsWith("-")) {
				minus = true;
			}
			int n = Integer.parseInt(number);
			if (minus) {
				if (n >= 0) {
					n = -n;
				}
			}
			r += n;
		}
		System.out.println(r);
	}

	private static void parseNumber(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-') {
				numbers.add(sb.toString());
				sb.setLength(0);
			}
			sb.append(ch);
		}
		numbers.add(sb.toString());
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine()
									   .trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}
