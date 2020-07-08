/*
ID: settysa1
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;
public class wormhole {
	static int N;
	static int maxN = 12;
	
	static int[] x = new int[maxN + 1];
	static int[] y = new int[maxN + 1];
	static int[] partners = new int[maxN + 1];
	static int[] nextOnRight = new int[maxN + 1];
	
	public static int solve() {
		// returns number of possible pairings
		int i, total = 0;
		for (i = 1; i <= N; i++)
			if (partners[i] == 0) break;
		
		// everyone paired?
		if (i > N) {
			if (cycleExists()) return 1;
			else return 0;
		}
		
		for (int j = i + 1; j <= N; j++) {
			if (partners[j] == 0) {
				partners[i] = j; partners[j] = i;
				total += solve();
				partners[i] = partners[j] = 0;
			}
		}
		
		return total;
	}
	
	public static boolean cycleExists() {
		for (int start = 1; start <= N; start++) {
			int pos = start;
			for (int count = 0; count < N; count++) {
				pos = nextOnRight[partners[pos]];
			}
			if (pos != 0)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		N = Integer.parseInt(f.readLine());
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (x[j] > x[i] && y[i] == y[j]) {
					if (nextOnRight[i] == 0 || x[j] - x[i] < x[nextOnRight[i]] - x[i]) {
						nextOnRight[i] = j;
					}
				}
			}
		}
		
		out.println(solve());
		out.close();
		f.close();
	}
	
	

}
