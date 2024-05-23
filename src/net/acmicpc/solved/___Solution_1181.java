package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ___Solution_1181 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 단어 정렬 - S5
	// https://www.acmicpc.net/problem/1181
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// 데이터 삽입, 중복제거
		HashSet<String> hs = new LinkedHashSet<>();
		for (int i = 0; i < n; i++) {
			hs.add(readLine());
		}
		ArrayList<String> words = new ArrayList<>(hs);

		// 길이 순, 길이가 같다면 사전 순 정렬
		words.sort(new Comparator<String>() {
			// 비교기준 설정
			@Override
			public int compare(String o1, String o2) {
				// 길이가 같은 경우, 사전 순 정렬
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				// 길이가 같지 않다면, 길이 비교
				return Integer.compare(o1.length(), o2.length());
			}
		});

		words.forEach(System.out::println);
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine()
									   .trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}
