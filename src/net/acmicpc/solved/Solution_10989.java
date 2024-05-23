package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_10989 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 수 정렬하기 3 - B1
	// https://www.acmicpc.net/problem/10989
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// 계수 정렬(Counting Sort)
		// -> 수가 많고, 수의 범위가 제한되어 있을 때, 해당 숫자의 갯수를 센다.
		int[] counts = new int[10_001];
		for (int i = 0; i < n; i++) {
			counts[readInt()] += 1;
		}

		for (int i = 0; i < counts.length; i++) {
			while (counts[i] > 0) {
				write(String.valueOf(i));
				counts[i] -= 1;
			}
		}

		close();
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

	private static void write(String s) throws IOException {
		bw.write(s);
		bw.newLine();
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		bf.close();
	}

}
