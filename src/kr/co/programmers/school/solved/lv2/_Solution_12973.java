package kr.co.programmers.school.solved.lv2;

import java.util.Stack;

public class _Solution_12973 {

	// 짝지어 제거하기 - lv.2
	// https://school.programmers.co.kr/learn/courses/30/lessons/12973
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "baabaa";
		System.out.println(sol.solution(s));
		// #case 2
		String s2 = "cdcd";
		System.out.println(sol.solution(s2));
	}

	static class Solution {

		public int solution(String s) {
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);

				// a. 스택이 비어있는 경우
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {  // b. 스택이 비어있지 않은 경우
					if (stack.peek() == ch) {  // b-1. 인접한 두 문자가 같은 경우
						stack.pop();
					} else {  // b-2. 인접한 두 문자가 다른 경우
						stack.push(ch);
					}
				}
			}

			return stack.isEmpty() ? 1 : 0;
		}

	}

}
