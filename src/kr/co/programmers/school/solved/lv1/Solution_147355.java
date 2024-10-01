package kr.co.programmers.school.solved.lv1;

public class Solution_147355 {

	// 크기가 작은 부분 문자열 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/147355
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String t = "3141592";
		String p = "271";
		System.out.println((sol.solution(t, p)));

		// #case 2
		String t2 = "500220839878";
		String p2 = "7";
		System.out.println((sol.solution(t2, p2)));

		// #case 3
		String t3 = "10203";
		String p3 = "15";

		System.out.println((sol.solution(t3, p3)));
	}

	static class Solution {

		public int solution(String t, String p) {
			int len = p.length();
			long val = Long.parseLong(p);

			int count = 0;
			for (int i = 0; i < t.length() - len + 1; i++) {
				long comp = Long.parseLong(t.substring(i, i + len));
				if (comp <= val) {
					count += 1;
				}
			}

			return count;
		}

	}

}
