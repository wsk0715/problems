package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ___Solution_8979 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 올림픽 - S5
	// https://www.acmicpc.net/problem/8979
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();
		int N = input[0];
		int K = input[1];

		List<List<Integer>> al = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			al.add(Arrays.stream(readIntegers())
						 .boxed()
						 .collect(Collectors.toList()));
		}

		Comparator<List<Integer>> comparator = new Comparator<>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// 금메달 갯수가 다르면
				if (o1.get(1) != o2.get(1)) {
					return Integer.compare(o2.get(1), o1.get(1));  // 금메달 갯수 비교, 큰 값을 앞으로 보내도록
				}
				// 은메달 갯수가 다르면
				if (o1.get(2) != o2.get(2)) {
					return Integer.compare(o2.get(2), o1.get(2));  // 은메달 갯수 비교
				}
				// 모두 같다면
				return Integer.compare(o2.get(3), o1.get(3));  // 동메달 갯수 비교
			}
		};

		// *정렬
		al.sort(comparator);

		//		al.forEach(System.out::println);  // test

		// *순위 부여
		int rank = 1;
		al.get(0).add(rank);  // 첫 번째 위치한 나라는 1위
		for (int i = 1; i < al.size(); i++) {
			List<Integer> previous = al.get(i - 1);
			List<Integer> current = al.get(i);

			// 메달 수가 같을 경우
			if (comparator.compare(previous, current) == 0) {
				current.add(rank);  // 동일 순위 부여
			} else {  // 순위가 다른 경우
				rank = i + 1;  // 순위 계산
				current.add(rank); // 순위 부여
			}
		}

		//		al.forEach(System.out::println);  // test

		// 순위 출력
		for (int i = 0; i < al.size(); i++) {
			List<Integer> current = al.get(i);
			if (current.get(0) == K) {
				write(current.get(4));
			}
		}

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
