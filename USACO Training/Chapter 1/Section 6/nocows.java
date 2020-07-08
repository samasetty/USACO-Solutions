/*
ID: settysa1
LANG: JAVA
TASK: nocows
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class nocows {
	static int N;
	static int K;
	static int[][] key = new int[101][202];

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")),true);
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= K; i++) {
			key[i][0] = key[i][1] = 1;
		}
		
		for (int i = 1; i <= K; i++)
			for (int j = 1; j <= N; j += 2)
				for (int c = 1; c < j; c += 2)
					key[i][j] = (key[i][j] + key[i - 1][c] * key[i - 1][j - c - 1]) % 9901;

		out.println((key[K][N] - key[K - 1][N] + 9901) % 9901);
		out.close();
		f.close();
	}

}
