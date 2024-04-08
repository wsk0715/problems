package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_11719 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 그대로 출력하기 2 - B3
	// https://www.acmicpc.net/problem/11719
	public static void main(String[] args) throws IOException {
		String input;
		StringBuilder sb = new StringBuilder();
		while ((input = readLine()) != null) {
			sb.append(input + "\n");
		}
		System.out.println(sb);
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

}
