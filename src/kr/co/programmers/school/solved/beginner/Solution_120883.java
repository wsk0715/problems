package kr.co.programmers.school.solved.beginner;

public class Solution_120883 {
	// 로그인 성공?
	// https://school.programmers.co.kr/learn/courses/30/lessons/120883
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String[] id_pw, String[][] db) {
			for (int i = 0; i < db.length; i++) {
				if (id_pw[0].equals(db[i][0])) {
					if (id_pw[1].equals(db[i][1])) {
						return "login";
					}
					return "wrong pw";
				}
			}
			return "fail";
		}

	}

}
