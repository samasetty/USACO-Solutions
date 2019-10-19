/*
ID: settysa1
LANG: JAVA
TASK: sort3
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class sort3 {
	static int[] arr;
	static int sCt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")),true);
		int ct = Integer.parseInt(f.readLine());
		arr = new int[ct];
		
		// get first counts
		int ct1 = 0, ct2 = 0, ct3 = 0;
		int hldr;
		for (int i = 0; i < ct; i++) {
			hldr = Integer.parseInt(f.readLine());
			arr[i] = hldr;
			if (hldr == 1) ct1++; 
			else if (hldr == 2) ct2++;
			else ct3++;
		}
		
		// see what doesn't belong
		int c21 = 0, c31 = 0, c12 = 0, c32 = 0, c13 = 0, c23 = 0;
		for (int i = 0; i < ct1; i++) {
			if (arr[i] == 2) c21++;
			else if (arr[i] == 3) c31++;
		}
		
		for (int i = ct1; i < ct1 + ct2; i++) {
			if (arr[i] == 1) c12++;
			else if (arr[i] == 3) c32++;
		}
		
		for (int i = ct1 + ct2; i < ct; i++) {
			if (arr[i] == 1) c13++;
			else if (arr[i] == 2) c23++;
		}
		
		// optimal swaps
		if (c21 > 0 && c12 > 0) {
			hldr = Math.min(c21, c12);
			sCt += hldr;
			c21 = c21 - hldr;
			c12 = c12 - hldr;
		}
		
		if (c31 > 0 && c13 > 0) {
			hldr = Math.min(c31, c13);
			sCt += hldr;
			c31 = c31 - hldr;
			c13 = c13 - hldr;
		}
		
		if (c23 > 0 && c32 > 0) {
			hldr = Math.min(c23, c32);
			sCt += hldr;
			c23 = c23 - hldr;
			c32 = c32 - hldr;
		}
		
		sCt += (((c12 + c21 + c13 + c31 + c23 + c32) * 2) / 3);
		out.println(sCt);

	}
}

