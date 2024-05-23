package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class _Solution_11650 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 좌표 정렬하기 - S5
	// https://www.acmicpc.net/problem/11650
	public static void main(String[] args) throws IOException {
		int n = readInt();

		int[][] pos = new int[n][2];
		for (int i = 0; i < n; i++) {
			pos[i] = readIntegers();
		}

		// 1. x좌표가 증가하는 순으로
		// 2. x좌표가 같으면 y좌표가 증가하는 순으로 정렬
		pos = Arrays.stream(pos)
					.sorted(new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							// x좌표가 같은 경우
							if (o1[0] == o2[0]) {
								// y좌표 비교
								return Integer.compare(o1[1], o2[1]);
							}
							// x좌표 비교
							return Integer.compare(o1[0], o2[0]);
						}
					})
					.toArray(int[][]::new);
		Arrays.stream(pos)
			  .forEach(arr -> {
				  String[] strArr = Arrays.stream(arr)
										  .mapToObj(String::valueOf)
										  .toArray(String[]::new);
				  String msg = String.join(" ", strArr);
				  System.out.println(msg);
			  });
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

	private static void write(String s) throws IOException {
		bw.write(s);
		bw.newLine();
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		br.close();
	}

}
