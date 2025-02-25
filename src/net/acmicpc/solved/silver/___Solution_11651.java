package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class ___Solution_11651 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 좌표 정렬하기 2 - S5
	// https://www.acmicpc.net/problem/11651
	public static void main(String[] args) throws IOException {
		int n = readInt();

		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i] = readIntegers();
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int x1 = o1[0];
				int y1 = o1[1];
				int x2 = o2[0];
				int y2 = o2[1];

				return y1 == y2 ? x1 - x2 : y1 - y2;
			}
		});

		for (int[] xy : arr) {
			int x = xy[0];
			int y = xy[1];

			bw.write(x + " " + y + "\n");
		}

		close();
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
