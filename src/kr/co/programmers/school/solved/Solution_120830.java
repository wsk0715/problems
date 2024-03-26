package kr.co.programmers.school.solved;

public class Solution_120830 {
	// 양꼬치
	// https://school.programmers.co.kr/learn/courses/30/lessons/120830
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n, int k) {
			int sum = 0;
			sum += 12_000 * n;
			sum -= 2_000 * (sum / 120_000);
			sum += 2_000 * k;

			return sum;
		}

	}

}
