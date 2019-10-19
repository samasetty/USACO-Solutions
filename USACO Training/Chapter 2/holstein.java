/*
ID: settysa1
LANG: JAVA
TASK: holstein
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class holstein {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")),true);
		V = Integer.parseInt(f.readLine());
		min = new int[V];
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		for (int i = 0; i < V; i++) {
			min[i] = Integer.parseInt(st.nextToken());
		}
		
		G = Integer.parseInt(f.readLine());
		scoop = new int[G][V];
		for (int i = 0; i < G; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < V; j++) {
				scoop[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		best = null;
		bestC = Integer.MAX_VALUE;
		
		recur(0,new boolean[G],0,new int[V]);
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < G;i++)
		{
			if(best[i]) ans.add(i+1);
		}
		Collections.sort(ans);
		out.print(ans.size());
		for(int a: ans)
			out.print(" "+a);
		out.println();
		
		out.close();
	}
	
	static int[] min;
	static int[][] scoop;
	static int V,G;
	
	static boolean[] best;
	static int bestC;
	
	public static void recur(int at, boolean[] used,int count,int[] vit)
	{
		if(at == used.length)
		{
			for(int i = 0; i < V;i++)
			{
				if(vit[i] < min[i]) return;
			}
			if(better(count,used))
			{
				bestC = count;
				best = used.clone();
			}
			return;
		}
		recur(at+1,used,count,vit);
		
		for(int i = 0; i < V;i++){
			vit[i] += scoop[at][i];
		}
		used[at] = true;
		recur(at+1,used,count+1,vit);
		for(int i = 0; i < V;i++){
			vit[i] -= scoop[at][i];
		}
		used[at] = false;
	}
	public static boolean better(int count, boolean[] used)
	{
		if(count < bestC) return true;
		if(count > bestC) return false;
		
		for(int i = 0; i < G;i++)
		{
			if(used[i] && !best[i]) return true;
			if(!used[i] && best[i]) return false;
		}
		return false;
	}
}
