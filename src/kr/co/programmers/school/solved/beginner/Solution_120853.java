package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;
import java.util.List;

public class Solution_120853 {
	// 컨트롤 제트
	// https://school.programmers.co.kr/learn/courses/30/lessons/120853
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String s) {
			ArrayList<String> arr = new ArrayList<>(List.of(s.split(" ")));
			int sum = 0;
			int recent = 0;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i)
					   .equals("Z")) {
					sum -= recent;
					continue;
				}
				int n = Integer.parseInt(arr.get(i));
				sum += n;
				recent = n;
			}
			return sum;
		}

	}

}
