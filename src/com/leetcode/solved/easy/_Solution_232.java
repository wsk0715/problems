package com.leetcode.solved.easy;

import java.util.Stack;

public class _Solution_232 {

	// 232. Implement Queue Using Stacks - Easy
	// https://leetcode.com/problems/implement-queue-using-stacks
	class MyQueue {
		// 1. 두 개의 스택(Stack)을 사용해 선입선출(FIFO) 방식의 큐(Queue)를 구현하라.
		// 2. 구현된 큐는 큐의 모든 일반적인 기능을 제공해야한다.
		// 2-1. push: 요소 x를 큐의 맨 뒤에 삽입한다.
		// 2-2. pop: 큐의 맨 앞에서 요소를 제거한 후, 반환한다.
		// 2-3. peek: 큐의 맨 앞에 있는 요소를 반환한다.
		// 2-4. empty: 큐가 비었으면 true, 아니면 false를 반환한다.
		// 3. x는 1 이상 9 이하이다.
		// 3-1. pop과 peek에 대한 모든 호출은 항상 유효하다.

		Stack<Integer> inputStack;
		Stack<Integer> outputStack;


		public MyQueue() {
			this.inputStack = new Stack<>();
			this.outputStack = new Stack<>();
		}

		public void push(int x) {
			inputStack.push(x);
		}

		public int pop() {
			if (outputStack.isEmpty()) {
				transfer();
			}
			return outputStack.pop();
		}

		public int peek() {
			if (outputStack.isEmpty()) {
				transfer();
			}
			return outputStack.peek();
		}

		public boolean empty() {
			return inputStack.isEmpty() && outputStack.isEmpty();
		}

		private void transfer() {
			while (!inputStack.isEmpty()) {
				outputStack.push(inputStack.pop());
			}
		}

	}

}
