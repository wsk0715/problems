package net.acmicpc.solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class $Solution_ {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	//
	// https://www.acmicpc.net/problem/
	public static void main(String[] args) throws IOException {
		int n = readInt();

	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

}
