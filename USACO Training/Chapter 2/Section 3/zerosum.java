/*
ID: settysa1
LANG: JAVA
TASK: zerosum
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
import java.util.Collections;

public class zerosum {
	static int N;
	static char[] key = new char[] {' ', '+', '-'};
	static ArrayList<String> ans = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")),true);
		N = Integer.parseInt(f.readLine());
		
		dfs(1, new StringBuilder("1"), 0, 1, true);
		Collections.sort(ans);
		for (String st : ans) out.println(st);
		
		out.close();
		f.close();
	}
	
	public static void dfs(int num, StringBuilder str, int sum, int left, boolean add) {	
		//System.out.println(str.toString() + " sum: "+ + sum);
		if (num == N) {
			if (sum + left == 0) { ans.add(str.substring(0)); } return;}
		
		dfs(num + 1, str.append("+").append(num + 1), sum + left, num + 1, true);
		str.delete(str.length() - 2, str.length());
		
		dfs(num + 1, str.append("-").append(num + 1), sum + left, -(num + 1), false);
		str.delete(str.length() - 2, str.length());
		
		dfs(num + 1, str.append(" ").append(num + 1), sum, left * 10 + (add?(num + 1):-(num + 1)), add);
		str.delete(str.length() - 2, str.length());
		
		//sum - (num - 1) + (10 * (num - 1)) + num
	}
}













