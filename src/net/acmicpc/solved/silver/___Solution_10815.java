package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ___Solution_10815 {

	static int N, M;

	// 숫자 카드 - S5
	// https://www.acmicpc.net/problem/10815
	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		// 찾아야 할 카드 목록 입력
		N = nextInt();               // 상근이 보유 카드 갯수
		int[] ownCards = new int[N]; // 보유 카드 목록
		for (int i = 0; i < N; i++) {
			ownCards[i] = nextInt();
		}

		// 찾아야 할 카드 목록 입력
		M = nextInt();                  // 찾아야 할 카드 갯수
		int[] targetCards = new int[M]; // 찾아야 할 카드 목록
		for (int i = 0; i < M; i++) {
			targetCards[i] = nextInt();
		}

		// 2. 전처리 - 이분 탐색을 위해 대상 배열 정렬
		Arrays.sort(ownCards);

		// 3. 결과 계산 - 찾으려는 카드가 보유한 카드 목록에 들어있는지 확인
		int[] result = new int[M];
		for (int i = 0; i < M; i++) {
			int start = 0;                   // 시작 인덱스
			int end = N - 1;                 // 종료 인덱스; 0-based index
			int targetCard = targetCards[i]; // 찾으려는 카드
			boolean found = false;           // 발견 여부

			// 탐색 시작
			while (start <= end) {
				int mid = (start + end) / 2;     // 현재 인덱스
				int currentCard = ownCards[mid]; // 현재 탐색중인 카드

				// 종료조건 - 현재 탐색 중인 값이 목표 값과 같을 때
				if (targetCard == currentCard) {
					found = true; // 발견 처리
					break;        // 탐색 종료
				}

				// 좌우 비교, 포인터 재설정
				if (targetCard < currentCard) {
					end = mid - 1;   // 탐색 범위 좌로 좁힘
				} else {
					start = mid + 1; // 탐색 범위 우로 좁힘
				}
			}

			// 결과 저장
			result[i] = found ? 1 : 0;
		}

		// 4. 결과 출력
		for (int i : result) {
			bw.write(i + " ");
		}
		close();
	}


	// Libraries
	private static StringTokenizer readLine() throws IOException {
		return new StringTokenizer(br.readLine());
	}

	private static int nextInt() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = readLine();
		}
		return Integer.parseInt(st.nextToken());
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

}
