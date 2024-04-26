package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class _Solution_120863 {
	// 다항식 더하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120863
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "3x + 7 + x";
		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			String[] arr = s.split(" ");

			int countX = 0;  // x항 총 계수
			int count = 0;  // 상수항 총 계수
			for (int i = 0; i < arr.length; i++) {
				String d = arr[i];
				if (d.equals("+")) {  // + 부호이면, 무시
					continue;
				}
				if (!d.contains("x")) {  // x가 없는 항이면, 상수항 총 계수에 값 더하고, 무시
					count += Integer.parseInt(d);
					continue;
				}
				if (d.equals("x")) {  // x항 계수가 1이면, x항 총 계수에 1 더하고, 무시
					countX += 1;
					continue;
				}
				// x항 계수만큼 x항 총 계수에 더하기
				countX += Integer.parseInt(d.replace("x", ""));
			}

			StringBuilder sb = new StringBuilder();
			if (countX != 0) {  // 1. x항 계수가 존재하면
				if (countX != 1) {  // 1-1. x항 계수가 1 아니면
					sb.append(countX);  // 1-2. x항 계수 붙임
				}
				sb.append("x");  // 2. 계수에 x 붙임
				if (count != 0) {  // 3. 상수항이 존재하면(x항 계수가 존재하고)
					sb.append(" + ");  // 3-1. + 부호 붙임
				}
			}
			if (count != 0) {  // 상수항이 존재하면
				sb.append(count);  // 상수항 붙임
			}

			System.out.println(sb);
			return sb.toString();
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
