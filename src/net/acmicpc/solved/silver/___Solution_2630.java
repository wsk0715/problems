package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ___Solution_2630 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[][] paper;
	static int white = 0;
	static int blue = 0;

	// 색종이 만들기 - S2
	// https://www.acmicpc.net/problem/2630
	public static void main(String[] args) throws IOException {
		int n = readInt();
		paper = new int[n][n];

		// 종이 상태 입력받기
		for (int i = 0; i < n; i++) {
			paper[i] = readIntegers();
		}

		divide(0, 0, n);

		write(white);
		write(blue);

		close();
	}

	static void divide(int x, int y, int size) {
		// a. 하나의 색상으로 표현되는지 확인
		if (isUnified(x, y, size)) {
			if (paper[x][y] == 0) {  // 0; 하얀색
				white += 1;
			} else {
				blue += 1;
			}
			return;  // 재귀 호출 종료
		}

		// b. 하나의 색상으로 표현되지 않는 경우, 4개 영역으로 분할하여 재귀 호출(통일된 색상인지 확인)
		int newSize = size / 2;  // b-1. 새로운 종이 크기 = 기존 종이의 절반 크기
		divide(x, y, newSize);  // 기존 종이를 4등분한 기준, 첫번째 영역(좌측 상단)
		divide(x, y + newSize, newSize);  // 두번째 영역(우측 상단)
		divide(x + newSize, y, newSize);  // 세번째 영역(좌측 하단)
		divide(x + newSize, y + newSize, newSize);  // 네번째 영역(우측 하단)
	}

	static boolean isUnified(int x, int y, int size) {
		// (x,y)에서 시작해서 size만큼의 크기가 통일된 색상인지 확인
		int color = paper[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (paper[i][j] != color) {
					return false;
				}
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
