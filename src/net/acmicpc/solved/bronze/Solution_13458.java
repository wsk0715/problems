package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_13458 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 시험 감독 - B2
	// https://www.acmicpc.net/problem/13458
	public static void main(String[] args) throws IOException {
		int N = readInt();

		int[] students = new int[N];
		StringTokenizer st = new StringTokenizer(readLine());
		for (int i = 0; i < N; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(readLine());
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());

		long r = 0;
		for (int i = 0; i < N; i++) {
			students[i] -= main;
			r += 1;

			if (students[i] > 0) {
				r += (students[i] + sub - 1) / sub;
			}
		}

		write(r);

		close();
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
