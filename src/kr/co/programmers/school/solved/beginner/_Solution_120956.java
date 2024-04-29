package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class _Solution_120956 {
	// 옹알이 (1)
	// https://school.programmers.co.kr/learn/courses/30/lessons/120956
	public static void main(String[] args) {
		Solution sol = new Solution();

		String[] input = {"aya", "yee", "u", "maa", "wyeoo"};
		sol.solution(input);
	}

	static class Solution {
		public int solution(String[] s) {
			// "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한다.
			String[] d = {"aya", "ye", "woo", "ma"};

			// 1. 사용 횟수를 저장할 배열
			int[] used = {0, 0, 0, 0};

			// 2. 입력받은 값 각각에 대해 가능 여부 확인
			int r = 0;
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < d.length; j++) {
					s[i] = s[i].replace(d[j], " ");  // (임시) 공백으로 변환
					used[j]++;
				}
				s[i] = s[i].replaceAll(" ", "");  // 공백을 다시 제거
				System.out.println(s[i]);

				if (s[i].equals("")) {
					r++;
				}
			}

			System.out.println(r);
			return r;
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

}
