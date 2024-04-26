package kr.co.programmers.school.solved.beginner;

public class Solution_120842 {
	// 2차원으로 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120842
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[][] solution(int[] num_list, int n) {
			int[][] arr = new int[num_list.length / n][n];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = num_list[n * i + j];
				}
			}
			return arr;
		}

	}

}
