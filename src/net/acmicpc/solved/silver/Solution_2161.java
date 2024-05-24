package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_2161 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 카드1 - S5
	// https://www.acmicpc.net/problem/2161
	public static void main(String[] args) throws IOException {
		int n = readInt();

		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(i + 1);
		}

		ArrayList<Integer> r = new ArrayList<>();
		while (!al.isEmpty()) {
			if (al.size() == 1) {  // 카드가 한 장 남은 경우
				r.add(al.remove(0));
				break;
			}
			int rm = al.remove(0);  // 버린 카드
			r.add(rm);  // 결과에 저장
			al.add(al.remove(0));
		}
		out(r);

	}

	private static void out(ArrayList<Integer> r) {
		StringBuilder sb = new StringBuilder();
		while (!r.isEmpty()) {
			sb.append(r.remove(0));
			sb.append(" ");
		}
		sb.replace(sb.length() - 1, sb.length(), "");
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
