package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 10726. 이진수 표현 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXRSXf_a9qsDFAXS
 */
public class Solution_10726 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int M = nextInt();

			String binaryNumber = toBinary(M);

			boolean flag = true;
			for (int i = binaryNumber.length() - 1; i > binaryNumber.length() - 1 - N; i--) {
				if (i < 0) {
					flag = false;
					break;
				}

				if (binaryNumber.charAt(i) != '1') {
					flag = false;
					break;
				}
			}

			sb.append("#").append(tc).append(" ");
			sb.append(flag ? "ON" : "OFF");
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	static String toBinary(int n) {
		StringBuilder num = new StringBuilder();

		if (n == 0) {
			return "0";
		}

		while (n > 0) {
			num.append(n % 2);
			n /= 2;
		}

		return num.reverse().toString();
	}


	// Libraries
	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null) {
				return null;
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
