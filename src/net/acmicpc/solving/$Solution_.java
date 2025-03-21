package net.acmicpc.solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class $Solution_ {

	static int N, M;

	//
	// https://www.acmicpc.net/problem/
	public static void main(String[] args) throws IOException {


		close();
	}


	// Libraries
	private static StringTokenizer readLine() throws IOException {
		return new StringTokenizer(br.readLine());
	}

	private static int nextInt() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = readLine();
		}
		return Integer.parseInt(st.nextToken());
	}


	private static <T> void write(T value) throws IOException {
		String s = String.valueOf(value);
		bw.write(s);
		bw.newLine();
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		br.close();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

}
