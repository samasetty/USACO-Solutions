/*
ID: settysa1
LANG: JAVA
TASK: spin
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class spin {
	static int[] speed = new int[5];
	static int[] ct = new int[5];
	static ArrayList<Integer>[] cut = (ArrayList<Integer>[])new ArrayList[5];

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("spin.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spin.out")),true);
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			speed[i] = Integer.parseInt(st.nextToken());
			int n = Integer.valueOf(st.nextToken());
			cut[i] = new ArrayList<Integer>();
			for (int j = 0;j < n*2;j++) cut[i].add(Integer.valueOf(st.nextToken()));
		}
		
		boolean[][] l = new boolean[5][360];
		for(int i = 0; i < 5;i++) {
			for(int j = 0; j < cut[i].size();j+=2) {
				for(int k = 0;k <= cut[i].get(j+1);k++)
					l[i][(cut[i].get(j)+k)%360] = true;
			}
		}
		
		int ans = -1;
		label:
		for(int t = 0; t < 360;t++)
		{
			boolean[][] e = new boolean[5][360];
			for(int i = 0; i < 5;i++) {
				int at = (t*speed[i])%360;
				for(int j = 0; j < 360;j++)
					e[i][(j+at)%360] = l[i][j];
			}
			for(int j = 0; j < 360;j++) {
				boolean yay = true;
				for(int i = 0; i < 5;i++)
					yay &= e[i][j];
				if(yay) {
					ans = t;
					break label;
				}
			}
		}
		if(ans == -1) out.println("none");
		else out.println(ans);

		out.close();
	}
}