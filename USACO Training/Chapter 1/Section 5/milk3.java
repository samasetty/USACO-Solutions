import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
ID: settysa1
LANG: JAVA
TASK: milk3
*/

public class milk3 {
	static boolean[][][] key = new boolean[21][21][21];
	static char[] key2 = new char[]{' ', 'a', 'b', 'c'};
	static int[] cap = new int[3];
	static Stack<Node> stack = new Stack<Node>();

	private static class Node {
		int[] milk = new int[3];
		Node(Node a) {
			this.milk[0]=a.milk[0];
            this.milk[1]=a.milk[1];
            this.milk[2]=a.milk[2];
		}
		
		Node(int a, int b, int c) {
			milk = new int[] {a, b, c};
		}
		
		public String toString() {
			return "" + milk[0] + ":" + milk[1] + ":" + milk[2];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		for (int i = 0; i < 2; i++) {
			cap[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.add(new Node(0, 0, cap[2]));
		key[0][0][cap[2]] = true;
		ArrayList<Integer> list = new ArrayList<Integer>();
		stack.push(new Node(0, 0, cap[2]));
		while (!stack.isEmpty()) {
			Node x = stack.pop();
			if (x.milk[0]==0 && !list.contains(x.milk[2])) {
                list.add(x.milk[2]);
            }
			
			pourAll(x);
			System.out.println(stack.toString());
		}
		
		System.out.println(list);
		
		out.close();
		f.close();
	}
	
	static Node pour(Node node, int from, int to) {
		if (node.milk[from] == 0) return node;
		
		Node newN = new Node(node);
		newN.milk[from] = ((node.milk[from] >= cap[to] - node.milk[to]) ? node.milk[from] - (cap[to] - node.milk[to]) : 0);
		newN.milk[to] = ((node.milk[from] >= cap[to] - node.milk[to]) ? cap[to] : node.milk[to] + node.milk[from]);
		return newN;
	}
	
	static void pourAll(Node node) {
		Node x = pour(node, 0, 1);
		if (!key[x.milk[0]][x.milk[1]][x.milk[2]] || !(x.milk[0] == 0)) {
			stack.push(x);
			key[x.milk[0]][x.milk[1]][x.milk[2]] = true;
		}
		
		x = pour(node, 0, 2);
		if (!key[x.milk[0]][x.milk[1]][x.milk[2]]) {
			stack.push(x);
			key[x.milk[0]][x.milk[1]][x.milk[2]] = true;
		}	
		
		x = pour(node, 1, 0);
		if (!key[x.milk[0]][x.milk[1]][x.milk[2]]) {
			stack.push(x);
			key[x.milk[0]][x.milk[1]][x.milk[2]] = true;
		}
		
	    x = pour(node, 1, 2);
	    if (!key[x.milk[0]][x.milk[1]][x.milk[2]]) {
			stack.push(x);
			key[x.milk[0]][x.milk[1]][x.milk[2]] = true;
		}
		
		x = pour(node, 2, 0);
		if (!key[x.milk[0]][x.milk[1]][x.milk[2]]) {
			stack.push(x);
			key[x.milk[0]][x.milk[1]][x.milk[2]] = true;
		}
		
		x = pour(node, 2, 1);
		if (!key[x.milk[0]][x.milk[1]][x.milk[2]]) {
			stack.push(x);
			key[x.milk[0]][x.milk[1]][x.milk[2]] = true;
		}
	}
}