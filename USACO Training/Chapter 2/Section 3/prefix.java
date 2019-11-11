/*
ID: settysa1
LANG: JAVA
TASK: prefix
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

public class prefix {
	static ArrayList<String> prim = new ArrayList<String>();
	static String seq = "";
	static boolean[] seen;
	static int ans = 0;
	static int[] indK = new int[26];

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")),true);
		
		// getting primitives
		String [][] prefixList=new String [26][70];
		int [][] prefixLengthList=new int [26][70];
		int [] prefixListCount=new int [26];
		String line;
		while (!(line=f.readLine()).equals(".")) {
			String [] prefixes=line.split(" ");
			for (int i=0;i<prefixes.length;i++) {
				int index=prefixes[i].charAt(0)-'A';
				prefixList[index][prefixListCount[index]]=prefixes[i];
				prefixLengthList[index][prefixListCount[index]++]=prefixes[i].length();
			}
		}
		
		// getting sequence
		StringBuilder sb = new StringBuilder();
		while ((line = f.readLine())!=null) {
			sb.append(line);
		}
		seq = sb.toString();
		
		int max = 0;
		seq = sb.toString();
		for (int i=0;i<Math.min(max+1,seq.length());i++) {
			int index=seq.charAt(i)-'A';
			for (int i2=0;i2<prefixListCount[index];i2++) {
				if (i+prefixLengthList[index][i2]>max && prefixLengthList[index][i2]<=seq.length()-i && seq.substring(i,i+prefixLengthList[index][i2]).equals(prefixList[index][i2])) {
					max=Math.max(max,i+prefixLengthList[index][i2]);
				}
			}
		}
		
		// find the answer
		out.println(max);
		
		out.close();
		f.close();

	}
	
	public static void dp(int len) {
		if (len > ans) ans = len;
		seen[len] = true;
		if (len >= seq.length()) return;
		char cur = seq.charAt(len);
		if (indK[cur - 65] == -1) return;
		for (int i = indK[cur - 65]; i < prim.size() && prim.get(i).charAt(0) == cur; i++) {
			int c = prim.get(i).length();
			if (c + len > ans && c + len <= seq.length() && seq.substring(len, c + len).equals(prim.get(i))) {
				if (!seen[c + len]) dp(c + len);
			}
		}
	}

}
