package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _Solution_2828 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 사과 담기 게임 - S5
	// https://www.acmicpc.net/problem/2828
	public static void main(String[] args) throws IOException {
		int[] inputs = readIntegers();
		int N = inputs[0];  // 칸 수
		int M = inputs[1];  // 바구니 크기

		int J = readInt();  // 사과 개수

		// 바구니 설정
		int left = 1;
		int right = M;
		int moves = 0;
		for (int i = 0; i < J; i++) {
			int pos = readInt();

			// 바구니보다 왼쪽에 있다면, 차이만큼 왼쪽으로 이동
			if (pos < left) {
				int sub = left - pos;
				left -= sub;
				right -= sub;
				moves += sub;
				continue;
			}

			// 바구니보다 오른쪽에 있다면, 차이만큼 오른쪽으로 이동
			if (pos > right) {
				int sub = pos - right;
				left += sub;
				right += sub;
				moves += sub;
			}
		}
		write(moves);

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
