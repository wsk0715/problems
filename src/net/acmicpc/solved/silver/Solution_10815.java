package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_10815 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 숫자 카드 - S5
	// https://www.acmicpc.net/problem/10815
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Set<Integer> cardsOwn = new HashSet<>();
		Arrays.stream(readIntegers())
			  .forEach(cardsOwn::add);

		int m = readInt();
		List<Integer> cardsTarget = new ArrayList<>();
		Arrays.stream(readIntegers()).forEach(cardsTarget::add);

		List<Integer> result = new ArrayList<>();
		for (Integer i : cardsTarget) {
			if (cardsOwn.contains(i)) {
				result.add(1);
			} else {
				result.add(0);
			}
		}

		write(result.stream()
					.map(String::valueOf)
					.collect(Collectors.joining(" ")));
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
