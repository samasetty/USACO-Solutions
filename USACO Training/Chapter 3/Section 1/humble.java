/*
ID: settysa1
LANG: JAVA
TASK: humble
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Math.min;

public class humble {
	static int N;
	static int K;
	static long[] p;
	static int[] index;
	static long[] hum;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("humble.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")),true);
		StringTokenizer st = new StringTokenizer(f.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		p = new long[K];
		
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < K; i++)
			p[i] = Integer.parseInt(st.nextToken());
		
		index = new int[K];
		hum = new long[N + 1];
		hum[0] = 1;
		long min = Long.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			min = Long.MAX_VALUE;
			for (int j = 0; j < K; j++) {
				while (p[j] * hum[index[j]] <= hum[i - 1])
					index[j]++;
				min = Math.min(min, p[j] * hum[index[j]]);
			}
			
			hum[i] = min;
		}
		
		out.println(hum[N]);
	}
}
