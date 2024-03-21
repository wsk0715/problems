package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_10773 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final ArrayList<Integer> arr = new ArrayList<>();

	// 제로 - S4
	// https://www.acmicpc.net/problem/10773
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			calc(readInt());
		}

		System.out.println(sol());
	}

	private static int sol() {
		return arr.stream()
				.mapToInt(Integer::intValue)
				.sum();
	}

	private static void calc(int i) {
		if (i == 0) {
			arr.remove(arr.size() - 1);
		} else {
			arr.add(i);
		}
	}


	// Libraries
	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

}
