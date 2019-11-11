/*
ID: settysa1
LANG: JAVA
TASK: hamming
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class hamming {
	static int N;
	static int B;
	static int D;
	static String[] list;
	static int to = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")),true);
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		list = new String[N];
		list[0] = "0";
		
		long start = System.currentTimeMillis();
		gen((int) Math.pow(2, B) - 1);
		
		int ct = 1;
		out.print(convert(list[0]));
		for (int i = 1; i < N; i++) {
			if (ct % 10 == 0) { out.println(); out.print(convert(list[i])); }
			else { out.print(" " + convert(list[i])); }
			ct++;
		}
		out.println();
		
		//System.out.println(279 / 10);
				
		out.close();
		f.close();
	}
	
	static void gen(int n) 
    { 
        // Create an empty queue of strings 
        Queue<String> q = new LinkedList<String>(); 
          
        // Enqueue the first binary number 
        q.add("1"); 
          
        while(n-- > 0)  { 
            String s1 = q.peek(); 
            q.remove(); 
            if (s1.length() >= D) {
            	check(s1); 
            }
            String s2 = s1; 
            q.add(s1 + "0"); 
            q.add(s2 + "1"); 
        } 
    }  
	
	static void check(String bin) {
		if (to > N - 1) return;
		int ct = 0;
		int count = 0;
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) == '1') {
				count++;
			}
		}
		
		if (!(count >= D)) return;
		int i = 0;
		//System.out.println(bin);
		while (i < N && list[i] != null) {
			
			if (!(hd(list[i], bin) >= D)) return;
			i++;
		}
		
		to++;
		if (to > N - 1) return;
		list[i] = bin;
	}
	
	static int hd(String a, String b) {
		if (a.length() > b.length()) {
			while (a.length() > b.length())
				b = "0" + b;
		} else if (a.length() < b.length()) {
			while (a.length() < b.length())
				a = "0" + a;
		}
		
		int ct = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				ct++;
		}
		return ct;
	}
	
	static int convert(String bi) {
		int bin = Integer.parseInt(bi);
		int factor = 1;
		int fin = 0;
		
		while (bin > 0) {
			fin += factor * (bin % 10);
			bin /= 10;
			factor *= 2;
		}
		
		return fin;
	}

}
