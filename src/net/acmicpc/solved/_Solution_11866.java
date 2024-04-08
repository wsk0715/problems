package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _Solution_11866 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 요세푸스 문제 - S5
	// https://www.acmicpc.net/problem/11866
	public static void main(String[] args) throws IOException {
		int[] ar = readIntegers();
		int n = ar[0];
		int k = ar[1];

		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(i + 1);
		}

		ArrayList<Integer> r = new ArrayList<>();
		int idx = 0;
		while (!al.isEmpty()) {
			idx += k - 1;
			idx %= al.size();
			r.add(al.remove(idx));
		}
		out(r);
	}

	private static void out(ArrayList<Integer> arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i) + ", ");
		}
		sb.replace(sb.length() - 2, sb.length(), "").append(">");
		System.out.println(sb);
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
