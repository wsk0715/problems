package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class __Solution_120875 {
	// 평행
	// https://school.programmers.co.kr/learn/courses/30/lessons/120875
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[][] input = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
		sol.solution(input);
		int[][] input2 = {{3, 5}, {4, 1}, {2, 4}, {5, 10}};
		sol.solution(input2);

		// 참고: https://school.programmers.co.kr/questions/75580
		int[][] input3 = {{1, 4}, {3, 8}, {5, 12}, {11, 6}};
		sol.solution(input3);
	}

	static class Solution {
		public int solution(int[][] dots) {
			// 점 조합(선분) 생성
			ArrayList<Line> al = new ArrayList<>();
			for (int i = 0; i < dots.length; i++) {
				for (int j = i + 1; j < dots.length; j++) {  // 서로 다른 두 점 선택
					al.add(new Line(dots[i], dots[j]));
				}
			}

			// 평행 여부 계산
			for (int i = 0; i < al.size(); i++) {
				for (int j = i + 1; j < al.size(); j++) {  // 서로 다른 두 선분 선택
					Line l1 = al.get(i);
					Line l2 = al.get(j);

					if (isDuplicatedDot(l1, l2)) {  // 선분의 시작점이나 종료점이 겹치는 경우, 무시
						continue;
					}

					if (Math.abs(l1.slope - l2.slope) < 0.0001) {  // 계산
						System.out.println(1);
						return 1;
					}
				}
			}
			System.out.println(0);
			return 0;
		}

		private boolean isDuplicatedDot(Line line1, Line line2) {
			// (시작점-시작점) 선분1의 시작점과 선분2의 시작점이 동일한 경우
			if ((line1.start.x == line2.start.x) && (line1.start.y == line2.start.y)) {
				return true;
			}
			// (시작점-종료점) 선분1의 시작점과 선분2의 종료점이 동일한 경우
			if ((line1.start.x == line2.end.x) && (line1.start.y == line2.end.y)) {
				return true;
			}
			// (종료점-시작점)선분2의 시작점과 선분1의 종료점이 동일한 경우
			if ((line2.start.x == line1.end.x) && (line2.start.y == line1.end.y)) {
				return true;
			}
			// (종료점-종료점) 선분1의 종료점과 선분2의 종료점이 동일한 경우
			if ((line1.end.x == line2.end.x) && (line1.end.y == line2.end.y)) {
				return true;
			}
			return false;
		}

	}

	static class Line {
		public final Dot start;
		public final Dot end;
		public final Double slope;

		Line(int[] start, int[] end) {
			this.start = new Dot(start);
			this.end = new Dot(end);
			this.slope = calcSlope();
		}

		private Double calcSlope() {
			return ((double) (end.y - start.y) / (end.x - start.x));
		}

	}

	static class Dot {
		public final int x;
		public final int y;

		Dot(int[] dot) {
			this.x = dot[0];
			this.y = dot[1];
		}

	}

}
