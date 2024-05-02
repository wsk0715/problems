package kr.co.programmers.school.solved.lv1;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_12969 {
	// 직사각형 별찍기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12969
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			int b = sc.nextInt();

			for (int i = 0; i < b; i++) {
				System.out.println("*".repeat(a));
			}
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
