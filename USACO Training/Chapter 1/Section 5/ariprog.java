/*
ID: settysa1
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ariprog {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		int n = Integer.parseInt(f.readLine());
		int m = Integer.parseInt(f.readLine());
		
		int MM2 = m*m*2;
		boolean[] bisq = new boolean[MM2 + 10];
		for (int i = 0; i <= m; i++) {
			for (int j = i; j <= m; j++) {
				bisq[i*i + j*j] = true;
			}
		}
		
		ArrayList<int[]> ans = new ArrayList<int[]>();
		for (int a = 0; a < MM2; a++) {
			if (!bisq[a]) continue;
			
			// (a + b*n) < bisq.length
			label:
			for (int b = 1; b <= (MM2 - a)/(n-1); b++) {
				for (int c = 1; c <= (n-1); c++) {
					if (!bisq[a + b * c]) continue label;
				}
				ans.add(new int[] {a, b});
			}
		}
		
		Collections.sort(ans, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[1] < b[1]) return -1;
			    if(a[1] > b[1]) return 1;
			    if(a[0] < b[0]) return -1;
			    if(a[0] < b[0]) return 1;
			    return 0;
			}
		});
		
		if (ans.size() == 0) out.println("NONE");
		else {
			for (int[] i : ans) {
				out.println(i[0] + " " + i[1]);
			}
		}
		out.close();
		f.close();

	}

}

