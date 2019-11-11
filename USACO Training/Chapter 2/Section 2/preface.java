/*
ID: settysa1
LANG: JAVA
TASK: preface
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class preface {
	static int N;
	static int[] fin = new int[7];
	static int[] hldr = new int[7];

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("preface.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")),true);
		N = Integer.parseInt(f.readLine());
		
		for (int i = 1; i <= N; i++) {
			// determine Is and Vs
			if (i % 10 == 4) { hldr[0] = 1; hldr[1] = 1; }
			else if (i % 10 == 9) { hldr[0] = 1; hldr[1] = 0; }
			else if (i % 10 == 5) hldr[0] = 0; 
			else if (i % 10 == 0) hldr[0] = 0;
			else hldr[0] += 1;
			
			// determine Xs and Ls
			if (i % 50 == 9) hldr[2] = 1;
			else if (i % 50 == 19) hldr[2] = 2;
			else if (i % 50 == 29) hldr[2] = 3;
			else if (i % 50 == 39) hldr[2] = 4;
			else if (i % 100 == 40) { hldr[2] = 1; hldr[3] = 1; }
			else if (i % 100 == 90) { hldr[2] = 1; hldr[3] = 0; }
			else if (i % 50 == 49) hldr[2] = 2;
			else if (i % 50 == 0) hldr[2] = 0;
			
			// determine Cs and Ds
			if (i % 500 == 90) hldr[4] = 1;
			else if (i % 500 == 190) hldr[4] = 2;
			else if (i % 500 == 290) hldr[4] = 3;
			else if (i % 500 == 390) hldr[4] = 4;
			else if (i % 1000 == 400) { hldr[4] = 1; hldr[5] = 1; }
			else if (i % 1000 == 900) { hldr[4] = 1; hldr[5] = 0; }
			else if (i % 500 == 490) hldr[4] = 2;
			else if (i % 500 == 0) hldr[4] = 0;
			
			// determine Ms
			if (i % 5000 == 900) hldr[6] = 1;
			else if (i % 5000 == 1900) hldr[6] = 2;
			else if (i % 5000 == 2900) hldr[6] = 3;
			
			fin[0] += hldr[0];
			fin[1] += hldr[1];
			fin[2] += hldr[2];
			fin[3] += hldr[3];
			fin[4] += hldr[4];
			fin[5] += hldr[5];
			fin[6] += hldr[6];
		}
		
		if (fin[0] > 0) out.println("I " + fin[0]);
		if (fin[1] > 0) out.println("V " + fin[1]);
		if (fin[2] > 0) out.println("X " + fin[2]);
		if (fin[3] > 0) out.println("L " + fin[3]);
		if (fin[4] > 0) out.println("C " + fin[4]);
		if (fin[5] > 0) out.println("D " + fin[5]);
		if (fin[6] > 0) out.println("M " + fin[6]);
		
	}

}
