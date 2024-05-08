package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_181946 {
	// 문자열 붙여서 출력하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181946
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String a = sc.next();
			String b = sc.next();

			System.out.println(String.join("", a, b));
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
