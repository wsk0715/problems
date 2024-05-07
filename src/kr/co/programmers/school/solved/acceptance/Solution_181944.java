package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_181944 {
	// 홀짝 구분하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181944
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();

			String msg = n + " is odd";
			if (n % 2 == 0) {
				msg = n + " is even";
			}
			System.out.println(msg);
		}


		// Libraries
		private int[] toArray(ArrayList<Integer> al) {
			// ArrayList<Integer> to int[]
			int[] arr = new int[al.size()];
			for (int i = 0; i < al.size(); i++) {
				arr[i] = al.get(i);
			}
			return arr;
		}

	}

}
