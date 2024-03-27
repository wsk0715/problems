package kr.co.programmers.school.solved;

public class Solution_120845 {
	// 주사위의 개수
	// https://school.programmers.co.kr/learn/courses/30/lessons/120845
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] box, int n) {
			int x, y, z;
			x = box[0] / n;
			y = box[1] / n;
			z = box[2] / n;
			return (x * y * z == 0) ? 0 : x * y * z;
		}

	}

}
