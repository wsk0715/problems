package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_25206 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 너의 평점은 - S5
	// https://www.acmicpc.net/problem/25206
	private static Map<String, Double> grades = new HashMap<>(Map.ofEntries(
			Map.entry("A+", 4.5),
			Map.entry("A0", 4.0),
			Map.entry("B+", 3.5),
			Map.entry("B0", 3.0),
			Map.entry("C+", 2.5),
			Map.entry("C0", 2.0),
			Map.entry("D+", 1.5),
			Map.entry("D0", 1.0),
			Map.entry("F", 0.0),
			Map.entry("P", -1.0)
	));

	public static void main(String[] args) throws IOException {
		double credit = 0;  // 학점
		double grade = 0;
		for (int i = 0; i < 20; i++) {
			String[] input = readLine().split(" ");

			double c = Double.parseDouble(input[1]);  // 학점
			double g = grades.get(input[2]);  // 평점
			if (g >= 0) {
				grade += g * c;
				credit += c;
			}
		}
		double r = grade / credit;
		System.out.printf("%6f", r);
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
