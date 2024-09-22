package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ___Solution_11403 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;
	static int[][] matrix;

	// 경로 찾기 - S1
	// https://www.acmicpc.net/problem/11403
	public static void main(String[] args) throws IOException {
		n = readInt();

		// 플루이드-워셜 알고리즘?
		// -> 모든 정점 쌍에 대한 경로 존재 여부를 파악하는 데 사용
		// -> 가중치 x, 모든 정점 N에 대한 인접 행렬이 나열된 상황에서 사용 가능
		matrix = new int[n][n];

		// 인접 행렬 입력
		for (int i = 0; i < n; i++) {
			int[] nodes = readIntegers();
			for (int j = 0; j < nodes.length; j++) {
				matrix[i][j] = nodes[j];
			}
		}

		// 플루이드-워셜 알고리즘 수행
		for (int i = 0; i < n; i++) {  // 경유지; 모든 노드를 경유지로 고려
			for (int j = 0; j < n; j++) {  // 출발지
				for (int k = 0; k < n; k++) {  // 도착지
					if (matrix[j][i] == 1 && matrix[i][k] == 1) {  // 출발지(j)에서 경유지(i)로 가는 경로가 존재하며, 경유지(i)에서 도착지(k)로 가는 경로가 존재한다면
						matrix[j][k] = 1;  // 출발지(j)에서 도착지(k)에 도달하는 경로가 존재한다.
					}
				}
			}
		}

		// logging
		//		for (int i = 0; i < matrix.length; i++) {
		//			System.out.println(Arrays.toString(matrix[i]));
		//		}

		// 결과 출력
		int[] res;
		for (int i = 0; i < n; i++) {
			res = new int[n];
			for (int j = 0; j < n; j++) {
				res[j] = matrix[i][j];
			}
			write(Arrays.stream(res)
						.mapToObj(String::valueOf)
						.collect(Collectors.joining(" ")));
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
