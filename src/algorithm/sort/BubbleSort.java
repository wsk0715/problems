package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/*
	 - 버블 정렬
	 - 첫 번째 원소부터 시작해서, 서로 인접한 두 원소를 비교한 후, 교환한다.
	 - 정렬 과정에서, 기존 배열은 '정렬되어있지 않은 부분'과 '정렬된 부분'으로 나뉜다.
	 - 결과적으로, 배열 마지막에는 항상 가장 큰 원소가 위치하게 된다.
	 */
	public static void sort(int[] arr) {
		int n = arr.length - 1;
		for (int i = 0; i < n; i++) {  // 1. 첫 번째 원소부터 시작해서,
			// 2. 아직 정렬되지 않은 부분까지( n-i: 마지막 i개의 원소는 이미 정렬되어있다. )
			for (int j = 0; j < n - i; j++) {
				if (arr[j] > arr[j + 1]) {  // 3. 인접 원소를 비교한 후, 교환한다.
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			// 4. 매 반복이 종료된 후, 이미 정렬된 부분의 끝에는 가장 큰 원소가 위치한다.
		}
		// 5. 배열의 모든 요소를 순회하면 반복이 끝난다.
	}

}
