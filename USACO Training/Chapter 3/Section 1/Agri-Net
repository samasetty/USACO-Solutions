/*
ID: settysa1
LANG: JAVA
TASK: agrinet
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class agrinet {
	static int N;
	static int[][] adjM;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("agrinet.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")),true);
		
		// inputting data
		N = Integer.parseInt(f.readLine());
		adjM = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			for (int j = 0; j < N; j++) {
				if (st.hasMoreTokens()) {
					adjM[i][j] = Integer.parseInt(st.nextToken());
				} else {
					st = new StringTokenizer(f.readLine());
					adjM[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// mst
		int[] vals = mst();
		int sum = 0;
		for (int i : vals) sum += i;
		out.println(sum);
		
		for (int i = 3; i < 384*2; i *= -2) {
			System.out.print(i);
			if (i != -384) System.out.print(", ");
		}
		
		out.close();
		f.close();
	}
	
	static int[] mst() {
		boolean[] marked = new boolean[N];
		int[] vals = new int[N];
		int[] mst = new int[N];
		
		for (int i = 1; i < N; i++) {
			vals[i] = Integer.MAX_VALUE;
			marked[i] = false;
		}
		
		mst[0] = -1;
		for (int i = 1; i < N; i++) {
			int j = minIndex(vals, marked);
			marked[j] = true;
			
			for (int k = 0; k < N; k++) {
				if (adjM[j][k] != 0 && marked[k] == false && adjM[j][k] < vals[k]) {
					mst[k] = j;
					vals[k] = adjM[j][k];
				}
			
			}
		}
		
		return vals;
	}
	
	static int minIndex(int vals[], boolean marked[]) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < N; i++) {
			if (marked[i] == false && vals[i] < min) {
				min = vals[i];
				index = i;
			}
		}
		
		return index;
	}
}
