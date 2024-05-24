package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1789 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 수들의 합 - S5
	// https://www.acmicpc.net/problem/1789
	public static void main(String[] args) throws IOException {
		long n = readLong();

		if (n < 3) {
			System.out.println(1);
		} else {
			System.out.println(sol(n));
		}
	}

	public static long sol(long n) {
		long i = 1;
		while (true) {
			long sum = calc(i);
			if (n <= sum) {
				return i - 1;
			}
			i += 1;
		}
	}

	public static long calc(long n) {
		long sum = 0;
		for (long i = 2; i <= n; i++) {
			sum += i;
		}
		return sum;
	}


	// Libraries
	private static long readLong() throws IOException {
		long value = Long.parseLong(bf.readLine().trim());
		return value;
	}

}

/*  idea
    1       1
    2       1
    3       2+1         2
    4       3+1
    5       3+2
    6       3+2+1       3
    7       4+2+1
    8       4+3+2
    9       4+3+2
    10      4+3+2+14    4
    11      5+3+2+1
    12      5+4+2+1
    13      5+4+3+1
    14      5+4+3+2
    15      5+4+3+2+1   5
    ...     ...         ...
 */
