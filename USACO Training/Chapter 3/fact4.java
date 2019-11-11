/*
ID: settysa1
LANG: JAVA
TASK: fact4
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

public class fact4 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("fact4.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
		N = Integer.parseInt(f.readLine());
		
		int cur = 1;
		int ct2 = 0;
		int ct5 = 0;
		int k;
		for(int i = 1; i <= N; i++) {
			k = i;
			while (k % 2 == 0) {
				ct2++; k /= 2;
			}
			while (k % 5 == 0) {
				ct5++; k /= 5;
			}
			cur = (cur * k) % 10;
		}

		for(int i = 0; i< ct2 - ct5; i++)
			cur = (cur * 2) % 10;
		
		out.println(cur % 10);
		out.close();
		f.close();

	}

}
