package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class _Solution_2164 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 카드2 - S4
	// https://www.acmicpc.net/problem/2164
	public static void main(String[] args) throws IOException {
		int n = readInt();

		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			dq.addLast(i + 1);
		}

		while (!dq.isEmpty()) {
			if (dq.size() == 1) {
				System.out.println(dq.getFirst());
				break;
			}
			dq.removeFirst();
			dq.addLast(dq.removeFirst());
		}
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

}
