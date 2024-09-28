package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_1620 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 나는야 포켓몬 마스터 이다솜 - S4
	// https://www.acmicpc.net/problem/1620
	public static void main(String[] args) throws IOException {
		int[] NM = readIntegers();
		int N = NM[0];
		int M = NM[1];

		String[] pokemons = new String[N + 1];
		Map<String, Integer> sequences = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String name = readLine();
			pokemons[i + 1] = name;
			sequences.put(name, i + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String input = readLine();

			// a. 숫자로만 이루어진 입력
			if (Character.isDigit(input.charAt(0))) {
				int seq = Integer.parseInt(input);
				sb.append(pokemons[seq]).append("\n");
				continue;
			}

			// b. 문자로만 이루어진 입력
			sb.append(sequences.get(input)).append("\n");
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
