package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2775 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 부녀회장이 될테야 - B1
	// https://www.acmicpc.net/problem/2775
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			int floor = readInt();
			int room = readInt();

			System.out.println(sol(floor, room));
		}
	}

	public static int sol(int floor, int room) {
		int n;
		if (room == 1) {
			n = 1;
		} else if (floor == 1) {
			n = (room * (1 + room)) / 2;
		} else {
			int[] persons = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
			for (int i = 1; i <= floor; i++) {
				for (int j = 1; j <= room; j++) {
					persons[j] += persons[j - 1];
				}
			}
			n = persons[room - 1];
		}
		return n;
	}


	// Libraries
	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

}

/*	idea

	3 - 1	5	15	35	70	..
	2 - 1	4	10	20	35	66	..
	1 - 1	3	6	10	15	21	28	36	45
	0 - 1	2	3	4	5	6	7	8	9

	-> i층의 j번째 사람 수 = i-1층의 j번째 + i층의 j-1번째
*/
