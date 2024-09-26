package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_7785 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 회사에 있는 사람 - S5
	// https://www.acmicpc.net/problem/7785
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int n = readInt();

		Set<String> members = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String[] command = readLine().split(" ");

			switch (command[1]) {
				case "enter":
					members.add(command[0]);
					break;
				case "leave":
					members.remove(command[0]);
					break;
			}
		}

		List<String> memberList = new ArrayList<>(members);
		memberList.sort(Comparator.reverseOrder());
		for (String member : memberList) {
			sb.append(member).append("\n");
		}

		write(sb);
		close();
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine()
								  .trim());
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(br.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
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
