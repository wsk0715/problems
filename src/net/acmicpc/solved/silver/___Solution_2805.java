package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ___Solution_2805 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 나무 자르기 - S2
	// https://www.acmicpc.net/problem/2805
	public static void main(String[] args) throws IOException {
		int[] params = readIntegers();
		int n = params[0];
		int m = params[1];

		int[] trees = readIntegers();
		int max = -1;
		for (int tree : trees) {
			max = Math.max(tree, max);
		}

		int left = 0;
		int right = max;
		int h = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			long current = calc(trees, mid);

			if (current >= m) {
				h = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		write(h);

		close();
	}

	static long calc(int[] trees, int h) {
		long sum = 0;
		for (int tree : trees) {
			if (tree > h) {
				sum += (tree - h);
			}
		}
		return sum;
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
