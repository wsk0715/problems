package net.acmicpc.solved.bronze;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_4796 {
	// 캠핑 - B1
	// https://www.acmicpc.net/problem/4796
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> result = new ArrayList();

		while (true) {
			String input = sc.nextLine();
			if (input.equals("0 0 0")) {
				break;
			}

			int[] values = new int[3];
			for (int i = 0; i < 3; i++) {
				String val = input.split(" ")[i];
				values[i] = Integer.parseInt(val);
			}
			result.add(calc(values[0], values[1], values[2]));
		}

		for (int i = 0; i < result.size(); i++) {
			System.out.printf("Case %s: %s\n", i + 1, result.get(i));
		}
	}

	public static int calc(int l, int p, int v) {
		int n = v / p;
		int m = Math.min(v % p, l);
		int val = l * n + m;
		return val;
	}

}
