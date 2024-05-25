package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class __Solution_2563 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 색종이 - S5
	// https://www.acmicpc.net/problem/2563
	public static void main(String[] args) throws IOException {
		// 가로/세로 각각 100인 도화지(필드)
		int[][] field = new int[100][100];

		// 색종이 입력
		int n = readInt();
		int[][] papers = new int[n][2];
		for (int i = 0; i < n; i++) {
			papers[i] = readIntegers();
		}

		// 결과 계산 - 색종이 붙이기
		int len = 10;
		for (int[] paper : papers) {
			int startX = paper[0];
			int startY = paper[1];
			int endX = startX + len;
			int endY = startY + len;

			for (int i = startX; i < endX; i++) {
				for (int j = startY; j < endY; j++) {
					field[i][j] += 1;
				}
			}
		}

		// 결과 계산 - 색종이 붙은 영역 계산
		int r = 0;
		for (int[] pos : field) {
			for (int p : pos) {
				r += p >= 1 ? 1 : 0;
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
