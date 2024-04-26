package kr.co.programmers.school.solved.beginner;

public class Solution_120812 {
	// 최빈값 구하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120812
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 3, 3, 4};
		solution(input);
	}

	public static int solution(int[] array) {
		int result = 0;

		int freq = -1;
		int[] counts = new int[1001];
		for (int i = 0; i < array.length; i++) {  // array 배열에 대해:
			counts[array[i]] += 1;  // array 배열의 i번째 수에 해당하는 갯수를 1만큼 증가

			if (freq < counts[array[i]]) {  // 최빈값 찾기: 지금까지 가장 많이 나온 횟수보다 크면:
				freq = counts[array[i]];  // freq: 가장 많이 나온 횟수(i)
				result = array[i];
			}
		}

		int count = 0;
		for (int i = 0; i < counts.length; i++) {
			if (freq == counts[i]) {
				count += 1;
			}
			if (count > 1) {
				result = -1;
				break;
			}
		}

		return result;
	}

}
