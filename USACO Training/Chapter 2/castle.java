/*
ID: settysa1
LANG: JAVA
TASK: castle
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;
import static java.lang.Math.max;

public class castle {
	static int m;
	static int n;
	static Room[] rooms;
	static Graph graph;
	static String[] key = {"", "W", "N", "WN", "E", "WE", "NE", "WNE",
			"S", "WS", "NS", "WNS", "ES", "WES", "NES", "WNES"};
	static CC cc;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")),true);
		StringTokenizer st = new StringTokenizer(f.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		rooms = new Room[m * n];
		graph = new Graph(m * n);
		
		int ct = 0;
		int hold = 0;
		for (int N = 0; N < n; N++) {
			st = new StringTokenizer(f.readLine());
			for (int M = 0; M < m; M++) {
				rooms[ct] = new Room(M, N, ct);
				hold = Integer.parseInt(st.nextToken());
				
				if (!key[hold].contains("W")) {
					graph.addEdge(ct, ct - 1);
				}
				
				if (!key[hold].contains("N")) {
					graph.addEdge(ct, ct - m);
				}
				
				if (!key[hold].contains("E")) {
					graph.addEdge(ct, ct + 1);
				}
				
				if (!key[hold].contains("S")) {
					graph.addEdge(ct, ct + m);
				}
				
				ct++;
			}
		}
		
		cc = new CC(graph);
		out.println(cc.count);
		out.println(Collections.max(cc.area));
		
		int maxArea = Integer.MIN_VALUE;
		Room maxRoom = null;
		char dir = 'k';
		int num;
		
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (i != (m - 1) && cc.id[i + j * m] != cc.id[i + 1 + j * m]) {
					num = cc.area.get(cc.id[i + j * m]) + 
							cc.area.get(cc.id[i + 1 + j * m]);
					if (num >= maxArea) {
						maxArea = max(maxArea, cc.area.get(cc.id[i + j * m]) + 
								cc.area.get(cc.id[i + 1 + j * m]));
						maxRoom = rooms[i + j * m];
						dir = 'E';
					}
				}
				
				if (j != 0 && cc.id[i + j * m] != cc.id[i + (j - 1) * m]) {
					num = cc.area.get(cc.id[i + j * m]) + 
							cc.area.get(cc.id[i + (j - 1) * m]);
					if (num >= maxArea) {
						maxArea = max(maxArea, cc.area.get(cc.id[i + j * m]) + 
								cc.area.get(cc.id[i + (j - 1) * m]));
						maxRoom = rooms[i + j * m];
						dir = 'N';
					}
				}
				
			}
		}
		
		out.println(maxArea);
		out.println(maxRoom + " " + dir);
		
		out.close();
		f.close();
	}

}

class Room {
	int m, n; // coords
	int id;
	int comp; // component id
	
	public Room(int m, int n, int id) {
		this.m = m;
		this.n = n;
		this.id = id;
	}
	
	public String toString() {
		return "" + (n + 1) + " " + (m + 1);
	}
}

class Graph {
	int V;
	int E;
	ArrayList<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}
}

class CC {
	boolean[] marked;
	int[] id;
	ArrayList<Integer> area;
	int count = 0;
	int ctr = 0;
	
	public CC(Graph G) {
		marked = new boolean[G.V];
		id = new int[G.V];
		area = new ArrayList<Integer>();
		for (int s = 0; s < G.V; s++) {
			if (!marked[s]) {
				dfs(G, s);
				area.add(ctr);
				count++;
				ctr = 0;
			}
		}
	}
	
	void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		ctr++;
		for (int w : G.adj[v]) {
			if (!marked[w])
				dfs(G, w);
		}
	}
}
