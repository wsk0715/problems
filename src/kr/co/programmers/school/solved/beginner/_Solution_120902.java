package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class _Solution_120902 {
	// 문자열 계산하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120902
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "3 + 4";
		sol.solution(input);
	}

	static class Solution {
		public int solution(String s) {
			String[] e = s.split(" ");
			// 0. 수 저장할 스택, 연산자 저장할 스택 생성
			ArrayList<Integer> numbers = new ArrayList<>();
			ArrayList<String> mods = new ArrayList<>();

			// 1. 수, 부호 분할
			for (int i = 0; i < e.length; i++) {
				String d = e[i];
				try {
					numbers.add(Integer.parseInt(d));
					continue;
				} catch (Exception ex) {
				}
				mods.add(d);
			}

			// 2. 계산
			int r = numbers.remove(0);  // 수 스택에서 첫 번째 수를 먼저 꺼낸다.
			while (!numbers.isEmpty()) {
				if (mods.remove(0)
						.equals("-")) {  // -연산
					r -= numbers.remove(0);
					continue;
				}
				r += numbers.remove(0);  // +연산
			}

			return r;
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
