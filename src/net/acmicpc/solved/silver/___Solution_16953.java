package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ___Solution_16953 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// A → B - S2
	// https://www.acmicpc.net/problem/16953
	public static void main(String[] args) throws IOException {
		int[] inputs = readIntegers();
		int A = inputs[0];
		int B = inputs[1];

		long result = bfs(A, B);
		write(result);

		close();
	}


	static class State {

		long value;
		long steps;

		State(long value, long steps) {
			this.value = value;
			this.steps = steps;
		}

	}

	private static long bfs(long current, long target) {
		Queue<State> queue = new LinkedList<>();
		Set<Long> visited = new HashSet<>();

		// 1. BFS - 큐에 초기 상태 삽입
		queue.offer(new State(current, 1));  // 최솟값에 1을 더한다.
		visited.add(current);

		// 2. 그래프 탐색
		while (!queue.isEmpty()) {
			State currentState = queue.poll();

			// 현재 상태가 목표 값에 도달했는지 확인
			if (currentState.value == target) {
				return currentState.steps;
			}

			// 도달하지 못한 경우: 두 가지 연산 가능
			long nextValue1 = currentState.value * 2;  // 연산 1: 2를 곱하는 연산
			long nextValue2 = currentState.value * 10 + 1;  // 연산 2: 수의 오른쪽에 1을 추가하는 연산

			// 연산 1 탐색
			if (!visited.contains(nextValue1) && nextValue1 <= target) {
				queue.offer(new State(nextValue1, currentState.steps + 1));
				visited.add(nextValue1);
			}

			// 연산 2 탐색
			if (!visited.contains(nextValue2) && nextValue2 <= target) {
				queue.offer(new State(nextValue2, currentState.steps + 1));
				visited.add(nextValue2);
			}
		}

		// 도달할 수 없는 경우
		return -1;
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
