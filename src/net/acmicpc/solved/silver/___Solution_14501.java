package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ___Solution_14501 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 퇴사 - S3
	// https://www.acmicpc.net/problem/14501
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];

		// a. T, P 입력
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		// b. 점화식 설정
		// b-1. 하루에 할 수 있는 선택은 두 가지
		//      i.  오늘 일을 하고 t[i]일 만큼 건너뛰는 경우
		//      ii. 오늘 일을 건너뛰는 경우
		int[] dp = new int[N + 2];
		for (int i = N; i >= 1; i--) {
			// 오늘 일을 할 수 없는 경우(퇴사일 초과)
			if (i + T[i] > N + 1) {
				dp[i] = dp[i + 1];
				continue;
			}

			// 오늘 일을 할 수 있는 경우
			dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i + 1]);  // i vs ii
		}

		write(dp[1]);

		close();
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	private static int[] readIntegers() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[st.countTokens()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		return arr;
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
