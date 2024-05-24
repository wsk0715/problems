package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_9012 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 괄호 - S4
	// https://www.acmicpc.net/problem/9012
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			String str = readLine();

			while (true) {
				if (str.contains("()")) {
					str = str.replace("()", "");
				} else {
					break;
				}
			}
			if (str.length() == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
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

}
