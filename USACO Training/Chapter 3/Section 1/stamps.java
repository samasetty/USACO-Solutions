/*
ID: settysa1
LANG: JAVA
TASK: stamps
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Math.min;

public class stamps {
	static int K;
	static int N;
	static int[] dp = new int[10000 * (200 + 3) + 3];
	static int[] ns;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("stamps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        K = Integer.parseInt(st.nextToken()); // total stamps that can be used
        N = Integer.parseInt(st.nextToken()); // number of different stamp values
        ns = new int[N];
       
        int ct = 0;
        String line;
        while ((line = f.readLine()) != null) {
        	st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
            	ns[ct] = Integer.parseInt(st.nextToken());
            	ct++;
            }
        }
        
        f.close();
        
        // starting values
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int n : ns) {
        	dp[n] = 1;
        }
        
        int ans = 0;
        int cur = Integer.MAX_VALUE;
        while (true) {
        	if (dp[ans] == 1 || dp[ans] == 0) { ans++; continue; }
        	for (int i = 0; i < N; i++) {
        		if (ans - ns[i] < 0) continue;
        		cur = min(cur, dp[ ans - ns[i] ] + 1);
        	}
        	if (cur > K) break;
        	else dp[ans] = cur;
        	cur = Integer.MAX_VALUE;
        	ans++;
        }
        
        out.println(ans - 1);
        out.close();
	}
}
