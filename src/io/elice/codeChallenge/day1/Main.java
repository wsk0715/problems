package io.elice.codeChallenge.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();  // 오늘 푼 문제 수

		String[] numbers = input.split("");  // 각 자리수를 배열에 집어넣기

		// 숫자로 변환
		int[] numArr = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numArr[i] = Integer.parseInt(numbers[i]);
		}

		// 오른쪽에서부터 왼쪽으로, 최초로 감소하는 수를 찾는다.
		int idx = -1;
		int target = -1;
		for (int i = numArr.length - 1; i >= 1; i--) {
			if (numArr[i - 1] < numArr[i]) {
				idx = i - 1;
				target = numArr[idx];
				break;
			}
		}

		// 오른쪽에서 시작해서, 처음으로 만나는 해당 수보다 큰 수와 자리를 바꾼다.
		for (int i = numArr.length - 1; i >= 1; i--) {
			if (target < numArr[i]) {
				int tmp = numArr[i];
				numArr[i] = numArr[idx];
				numArr[idx] = tmp;
				break;
			}
		}

		// 해당 인덱스를 기준으로 오른쪽에 있는 수를 오름차순 정렬한다.
		Arrays.sort(numArr, idx + 1, numArr.length);

		// 배열을 다시 문자열로 변환 후, 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numArr.length; i++) {
			sb.append(numArr[i]);
		}

		System.out.println(sb);
	}

}
