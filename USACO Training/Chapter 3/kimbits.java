/*
ID: settysa1
LANG: JAVA
TASK: kimbits
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class kimbits {
	static int N;
	static int L;
	static long I;
	static int[][] dp;
	public static String ans = "";

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("kimbits.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")),true);
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		I = Long.parseLong(st.nextToken());
		dp = new int[N + 1][L + 1];
		dp();
		bits(N, L, I - 1);
		out.println(ans);
		
		out.close();
		f.close();
	}
	
	public static void dp() {
		for(int j = 0; j < L + 1; j++)
			dp[0][j] = 1;

		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < L + 1; j++) {
				if (j == 0) dp[i][j] = 1;
				else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}
	}
	
	public static void bits(int n, int l, long num) {
		if (n == 0) return;
		if (num >= dp[n - 1][l]) {
			ans += "1";
			bits(n - 1, l - 1, num - dp[n - 1][l]);
		} else {
			ans += "0";
			bits(n - 1, l, num);
		}
			
	}

}
