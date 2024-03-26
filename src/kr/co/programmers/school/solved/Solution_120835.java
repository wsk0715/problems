package kr.co.programmers.school.solved;

import java.util.Arrays;

public class Solution_120835 {
	// 진료순서 정하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120835
	public static void main(String[] args) {
		int[] input = new int[]{30, 10, 23, 6, 100};
		solution(input);
	}

	public static int[] solution(int[] emergency) {
		int[] result = new int[emergency.length];

		int[] sortedEmergency = Arrays.copyOf(emergency, emergency.length);  // 정렬을 위해 배열 복제
		Arrays.sort(sortedEmergency);  // 복제된 배열 정렬(오름차순)

		int count = 0;
		for (int i = sortedEmergency.length - 1; i >= 0; i--) {  // 뒤에서부터 순회: 최대값부터 순회
			for (int j = 0; j < emergency.length; j++) {  // 원본 배열에 대해서,
				if (sortedEmergency[i] == emergency[j]) {  // 최대값(i)을 찾으면(j)
					result[j] = ++count;  // result 배열의 해당 인덱스(i)에 순위 부여
				}
			}
		}

		return result;
	}

}
