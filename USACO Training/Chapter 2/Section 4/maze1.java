/*
ID: settysa1
LANG: JAVA
TASK: maze1
*/

import static java.lang.Math.max;
import static java.lang.Math.min;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class maze1 {
	static int W, H;
	static int A, B;
	static Graphh g;
	static ArrayList<Integer> exits = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")),true);
		StringTokenizer st = new StringTokenizer(f.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		g = new Graphh(W * H);
		
		char[][] input = new char[2 * H + 1][2 * W + 1];
        for (int i = 0; i < 2 * H + 1; i++) {
            input[i] = f.readLine().toCharArray();
        }
		
		// 2nd line
		for (int i = 1; i < (2 * W) + 1; i += 2) {
			if (input[0][i] == ' ') { 
				exits.add((i - 1) / 2);
			}
		}
		
		// 3nd line - 2*H + 1
		for (int i = 1; i < (2 * H) + 1; i += 2) {
			
			// check if hole
			if (input[i][0] == ' ') { 
				exits.add(W * (i / 2));
			}
			
			// check node connections
			for (int j = 1; j < (2 * W); j += 2) {
				if (i != 1) {
					if (input[i - 1][j] == ' ') {
						g.addEdge(W * (i / 2) + (j / 2), W * ((i - 2) / 2) + (j / 2));
					}
				}
				
				if (j != (2 * W) - 1) {
					if (input[i][j + 1] == ' ') {
						g.addEdge(W * (i / 2) + (j / 2), W * (i / 2) + (j / 2) + 1);
					}
				}
				
				if (i != (2 * H) - 1) {
					if (input[i + 1][j] == ' ') {
						g.addEdge(W * (i / 2) + (j / 2), W * ((i + 2) / 2) + (j / 2));
					}
				}
					
				if (j != 1) {
					if (input[i][j - 1] == ' ') {
						g.addEdge(W * (i / 2) + (j / 2), W * (i / 2) + (j / 2) - 1);
					}
				}
			}
			
			// check last if hole
			if (input[i][2 * W] == ' ') { 
				exits.add(W * (1 + (i / 2)) - 1);
			}
		}
		
		// Line 2*H + 2
		for (int i = 1; i < (2 * W) + 1; i += 2) {
			if (input[2 * H][i] == ' ') { 
				exits.add((W * (H - 1)) + ((i - 1) / 2));
			}
		}
		
		//System.out.println(bfs(exits.get(0)));
		out.println(bfs(exits.get(0), exits.get(1)));
		
	}
	
	public static int bfs(int srcA, int srcB) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] marked = new boolean[W * H];
		int[] distToA = new int[W * H];
		int max = 0;
		int[] mins = new int[W * H];
		
        for (int v = 0; v < g.V; v++)
            distToA[v] = Integer.MAX_VALUE;
        distToA[srcA] = 0;
        mins[srcA] = 0;
        marked[srcA] = true;
        q.add(srcA);

        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : g.adj[v]) {
                if (!marked[w]) {
                    distToA[w] = distToA[v] + 1;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
        
        Arrays.fill(marked, false);
        int[] distToB = new int[W * H];
        
        for (int v = 0; v < g.V; v++)
            distToB[v] = Integer.MAX_VALUE;
        distToB[srcB] = 0;
        marked[srcB] = true;
        mins[srcB] = 0;
        q.add(srcB);
        
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : g.adj[v]) {
                if (!marked[w]) {
                    distToB[w] = distToB[v] + 1;
                    marked[w] = true;
                    q.add(w);
                    mins[w] = min(distToA[w], distToB[w]);
                    max = max(max, mins[w]);
                }
            }
        }
        
        return max + 1;
        //System.out.println(max2);
	}
}

//got the graph code from Algorithms by Sedgewick and Wayne
//most of this isn't mine - but made adjustments
class Graphh {
	int V;
	int E;
	ArrayList<Integer>[] adj;
	
	public Graphh(int V) {
		this.V = V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		//adj[w].add(v); rmbrrrrr!!!
		E++;
	}
}
