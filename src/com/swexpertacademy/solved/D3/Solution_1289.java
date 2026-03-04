package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1289. 원재의 메모리 복구하기 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN
 */
public class Solution_1289 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int cnt = 0;
			for (char c : br.readLine().trim().toCharArray()) {
				// 앞에서 짝수 번 반복한 경우, 현재 위치는 원래 값 그대로
				if (cnt % 2 == 0) {
					// 짝수 번 변경 후 현재 값이 1인 경우, 바꿔야 함
					if (c == '1') {
						cnt += 1;
					}
				} else {
					// 홀수 번 변경 후 현재 값이 0인 경우, 바꿔야 함
					if (c == '0') {
						cnt += 1;
					}
				}
			}

			sb.append(cnt);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
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
