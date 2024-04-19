package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_120921 {
	// 문자열 밀기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120921
	public static void main(String[] args) {
		Solution sol = new Solution();

		String a = "hello";
		String b = "ohell";
		sol.solution(a, b);
	}

	static class Solution {
		public int solution(String a, String b) {
			if (a.equals(b)) {  // a와 b가 동일하면
				return 0;  // 이동횟수: 0회
			}

			// a와 b가 같아지기 위해 필요한 이동 횟수 도출
			for (int i = 1; i < a.length(); i++) {
				a = push(a);
				if (a.equals(b)) {  // a와 b가 같아지면
					return i;  // 이동횟수 반환
				}
			}

			return -1;  // 같아질 수 없을 시
		}

		public String push(String s) {
			StringBuilder sb = new StringBuilder(s.substring(s.length() - 1));
			sb.append(s.substring(0, s.length() - 1));

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
