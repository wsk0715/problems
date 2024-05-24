package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _Solution_2292 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 벌집 - B2
	// https://www.acmicpc.net/problem/2292
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// 벌집 -> 6각형 ?
		// 중앙에서 1칸씩 나눈다.
		// 한 칸을 완성시키는 수는?
		// 1 -> 7 -> 19 -> 37 -> 61 -> ..
		// +6 -> +12 -> +18 -> +24 -> ..

		ArrayList<Integer> dp = new ArrayList<>();
		dp.add(1);
		while (true) {
			int l = dp.size() - 1;

			if (dp.get(l) >= n) {
				break;
			}

			dp.add(dp.get(l) + 6 * (++l));
		}
		System.out.println(dp.size());
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
