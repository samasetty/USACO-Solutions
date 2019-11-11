/*
ID: settysa1
LANG: JAVA
TASK: subset
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class subset {
	static int N;
	static int sum;
	static long[][] key;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("subset.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")),true);
		N = Integer.parseInt(f.readLine());
		
		for (int i = 1; i < N + 1; i++) {
			sum += i;
		}
		
		if (sum % 2 != 0) out.println(0);
		else {
			key = new long[sum / 2 + 1][N + 1];
			for (int i = 0; i < key.length; i++)
				Arrays.fill(key[i], -1);
			out.println(subsets(sum / 2, N) / 2);
		}
		
		out.close();
		f.close();
	}
	
	public static long subsets(int n, int k) {
		if (n < 0 || k < 0) return 0;
		if (n == 0 && k == 0) return key[n][k] = 1;
		if (key[n][k] != -1) return key[n][k];
		return key[n][k] = subsets(n, k - 1) + subsets(n - k, k - 1);
	}

}
