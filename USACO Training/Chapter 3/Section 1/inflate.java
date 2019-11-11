/*
ID: settysa1
LANG: JAVA
TASK: inflate
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class inflate {
	static int M;
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dp = new int[M + 1];
		
		int p, m;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			p = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			for (int j = m; j <= M; j++) {
				dp[j] = Math.max(dp[j], dp[j - m] + p);
			}
		}
		
		int ans = 0;
		for(int i = 0; i <= M; i++)
			if(ans < dp[i]) ans = dp[i];
		
		out.println(ans);
		
		out.close();
		f.close();

	}

}
