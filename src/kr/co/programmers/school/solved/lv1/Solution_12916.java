package kr.co.programmers.school.solved.lv1;

public class Solution_12916 {
	// lv.1 문자열 내 p와 y의 개수
	// https://school.programmers.co.kr/learn/courses/30/lessons/12916
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		boolean solution(String s) {
			int np = 0;
			int ny = 0;

			s = s.toLowerCase();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'p') {
					np++;
					continue;
				}
				if (s.charAt(i) == 'y') {
					ny++;
				}
			}
			return (np == ny) ? true : false;
		}

	}

}
