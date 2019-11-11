/*
ID: settysa1
LANG: JAVA
TASK: concom
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
import java.util.StringTokenizer;

public class concom {
	static int N;
	static int max = 101;
	static boolean[][] controlled;
	static int[][] owns;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("concom.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")),true);
		N = Integer.parseInt(f.readLine());
		controlled = new boolean[max][max];
		owns = new int[max][max];
		
		for (int i = 0; i < max; i++) {
            controlled[i][i] = true;
        }
		
		System.out.println(N);
		
		StringTokenizer st;		
		int a, b, c;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			addowner(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if (i!=j && controlled[i][j]) out.println(i + " " + j);
			}
		}
	}
	
	public static void addowner(int a, int b, int p) {
		
		// anything that controls a should get b's ownings
		for (int i = 0; i < max; i++) {
			if (controlled[i][a]) owns[i][b] += p;
		}
		
		// check for new controlled companies
		for (int i = 0; i < max; i++) {
			
			if (owns[i][b] > 50) addcontroller(i, b);
		}
	}
	
	public static void addcontroller(int a, int b) {
		if (controlled[a][b]) return;
		
		controlled[a][b] = true;
		
		// first add b's ownings to a's
		for (int i = 0; i < max; i++) {
			owns[a][i] += owns[b][i];
		}
		
		// then anything that controls a also controls b
		for (int i = 0; i < max; i++) {
			if (controlled[i][a]) {
				addcontroller(i, b);
			}
		}
		
		// check if a controls more companies now
		for (int i = 0; i < max; i++) {
			if (owns[a][i] > 50) addcontroller(a, i);
		}
	}
}
