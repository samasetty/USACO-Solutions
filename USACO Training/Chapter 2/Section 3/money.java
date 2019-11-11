/*
ID: settysa1
LANG: JAVA
TASK: money
*/

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class money {
	static int N;
	static int V;
	static int[] coins;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("money.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")),true);
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		V = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		coins = new int[V];
		
		String line;
		int ct = 0;
		while ((line = f.readLine()) != null) {
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) { 
				coins[ct] = Integer.parseInt(st.nextToken()); 
				ct++;
			}
		}
		
		dp = new long[V + 1][N + 1];
		for (int i = 0; i < V + 1; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i < V + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (coins[i - 1] > j) dp[i][j] = dp[i - 1][j];
				else { dp[i][j] = dp[i - 1][j] + dp[i][j-coins[i-1]]; }
			}
		}
		
		out.println(dp[V][N]);

	}

}
