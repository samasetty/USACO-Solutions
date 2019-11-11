/*
ID: settysa1
LANG: JAVA
TASK: runround
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class runround {
	static int N;
	static int[] key = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	static boolean tr = false;
	static PrintWriter out;
	static BufferedReader f;
	
	public static void main(String[] args) throws IOException {
		f = new BufferedReader(new FileReader("runround.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")),true);
		N = Integer.parseInt(f.readLine());
		
		gen(N);
		
		out.close();
		f.close();
	}
	
	public static void gen(int gre) {
		boolean[] visited;
		int num, sum, ct;
		
		for (int i = gre + 1; i < 987654322; i++) {
			num = i;
			
			visited = new boolean[10];
			sum = 0;
			ct = 0;
			
			while (num > 0) {
				if (visited[num % 10]) break;
				if (num % 10 == 0) break;
				visited[num % 10] = true;
				sum += (num % 10);
				ct++;
				
				num = num / 10;
			}
			
			if (num == 0 && sum % ct == 0) { check(i, ct); }
		}
	}
	
	public static void check(int n, int len) {
		String temp = Integer.toString(n);
		int[] num = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
		    num[i] = temp.charAt(i) - '0';
		}
		
		boolean[] visited = new boolean[len];
		int mk = 0;
		for (int i = 0; i < len; i++) {
			if (visited[mk]) return;
			visited[mk] = true;
			
			mk = (num[mk] + mk) % len;
		}
		
		out.println(n);
		
		System.exit(0);
	}
}
