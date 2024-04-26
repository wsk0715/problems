package kr.co.programmers.school.solved.beginner;

public class Solution_120861 {
	// 캐릭터의 좌표
	// https://school.programmers.co.kr/learn/courses/30/lessons/120861
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(String[] keyinput, int[] board) {
			int x = 0;
			int y = 0;

			for (int i = 0; i < keyinput.length; i++) {
				switch (keyinput[i]) {
					case "left":
						x -= 1;
						break;
					case "right":
						x += 1;
						break;
					case "up":
						y += 1;
						break;
					case "down":
						y -= 1;
						break;
				}

				int bx = board[0];
				int by = board[1];
				if (x < -bx / 2) {
					x = -bx / 2;
				}
				if (x > bx / 2) {
					x = bx / 2;
				}
				if (y < -by / 2) {
					y = -by / 2;
				}
				if (y > by / 2) {
					y = by / 2;
				}
			}
			return new int[]{x, y};
		}

	}

}
