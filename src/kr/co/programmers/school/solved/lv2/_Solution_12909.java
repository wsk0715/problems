package kr.co.programmers.school.solved.lv2;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class _Solution_12909 {
	// 올바른 괄호 - lv.2
	// https://school.programmers.co.kr/learn/courses/30/lessons/12909
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		boolean solution(String s) {
			Stack<String> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					stack.push("(");
					continue;
				}
				try {
					stack.pop();
				} catch (EmptyStackException e) {
					return false;
				}
			}
			if (!stack.empty()) {
				return false;
			}
			return true;
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
