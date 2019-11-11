/*
ID: settysa1
LANG: JAVA
TASK: lamps
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class lamps {
	static int N;
	static int C;
	static boolean[] mbOn;
	static boolean[] mbOff;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("lamps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));

		int N = sc.nextInt();
		int C = sc.nextInt();
        ArrayList<Integer> setOn = new ArrayList<Integer>();
		while(true)
		{
			int temp = sc.nextInt();
			if(temp == -1) break;
			setOn.add(temp-1);
		}
		
		ArrayList<Integer> setOff = new ArrayList<Integer>();
		while(true)
		{
			int temp = sc.nextInt();
			if(temp == -1) break;
			setOff.add(temp-1);
		}
		boolean[] lights = new boolean[N];
		Arrays.fill(lights,true);
		
		r = new boolean[2][2][2][2][N];
		r[0][0][0][0] = lights;
		
		r[0][0][0][1] = move1(lights);
		r[0][0][1][0] = move2(lights);
		r[0][1][0][0] = move3(lights);
		r[1][0][0][0] = move4(lights);
		
		r[0][0][1][1] = move1(move2(lights));
		r[0][1][0][1] = move1(move3(lights));
		r[1][0][0][1] = move1(move4(lights));
		r[0][1][1][0] = move2(move3(lights));
		r[1][0][1][0] = move2(move4(lights));
		r[1][1][0][0] = move3(move4(lights));
		
		r[1][1][1][0] = move2(move3(move4(lights)));
		r[1][1][0][1] = move1(move3(move4(lights)));
		r[1][0][1][1] = move1(move1(move4(lights)));
		r[0][1][1][1] = move1(move2(move3(lights)));
		
		r[1][1][1][1] = move1(move2(move3(move4(lights))));
		
		ArrayList<Answer> list = new ArrayList<Answer>();
		for(int i = 0; i < 2;i++)
		{
			for(int j = 0; j < 2;j++)
			{
				for(int k = 0; k < 2;k++)
				{
					for(int m = 0; m < 2;m++)
					{
						if(C-i-j-k-m >= 0 && (C-i-j-k-m)%2 == 0)
						{
							boolean legal = true;
							for(int on:setOn)
							{
								if(!r[i][j][k][m][on])legal = false;
							}
							for(int off:setOff)
							{
								if(r[i][j][k][m][off])legal = false;
							}
							if(legal) list.add(new Answer(i,j,k,m));
						}
					}
				}
			}
		}
		Collections.sort(list);
		for(Answer a: list)
		{
			out.println(a.toString());
		}
		if(list.size() == 0)
			out.println("IMPOSSIBLE");
		out.close();
	}
	static boolean[][][][][] r;
	private static class Answer implements Comparable<Answer>
	{
		int i,j,k,m;
		public Answer(int a, int b, int c, int d)
		{
			i=a;
			j=b;
			k=c;
			m=d;
		}
		public int compareTo(Answer a) {
			for(int t = 0; t < r[0][0][0][0].length;t++)
			{
				if(r[i][j][k][m][t] && !r[a.i][a.j][a.k][a.m][t]) return 1;
				if(!r[i][j][k][m][t] && r[a.i][a.j][a.k][a.m][t]) return -1;
			}
			return 0;
		}
		public String toString()
		{
			String out = "";
			for(int t = 0; t < r[0][0][0][0].length;t++)
			{
				if(r[i][j][k][m][t]) out = out+"1";
				else out = out+"0";
		
			}
			return out;
		}
		
	}
	public static boolean[] move1(boolean[] in)
	{
		boolean[] ret = new boolean[in.length];
		for(int i = 0; i < ret.length;i++)
		{
			ret[i] = !in[i];
		}
		return ret;
	}
	public static boolean[] move2(boolean[] in)
	{
		boolean[] ret = new boolean[in.length];
		for(int i = 0; i < ret.length;i++)
		{
			if(i%2 == 1)
				ret[i] = !in[i];
			else
				ret[i] = in[i];
		}
		return ret;
	}
	public static boolean[] move3(boolean[] in)
	{
		boolean[] ret = new boolean[in.length];
		for(int i = 0; i < ret.length;i++)
		{
			if(i%2 == 0)
				ret[i] = !in[i];
			else
				ret[i] = in[i];
		}
		return ret;
	}
	public static boolean[] move4(boolean[] in)
	{
		boolean[] ret = new boolean[in.length];
		for(int i = 0; i < ret.length;i++)
		{
			if(i%3 == 0)
				ret[i] = !in[i];
			else
				ret[i] = in[i];
		}
		return ret;
	}
	
	public static void master(int[] arr) {
		System.out.println(Arrays.toString(one(arr.clone())));
		System.out.println(Arrays.toString(two(arr.clone())));
		System.out.println(Arrays.toString(three(arr.clone())));
		System.out.println(Arrays.toString(four(arr.clone())));
	}
	
	public static int[] one(int[] arr) {
		for (int i = 0; i < N; i++) {
			if (arr[i] == 0) arr[i] = 1;
			else if (arr[i] == 1) arr[i] = 0;
		}
		
		return arr;
	}
	
	public static int[] two(int[] arr) {
		for (int i = 0; i < N; i += 2) {
			if (arr[i] == 0) arr[i] = 1;
			else if (arr[i] == 1) arr[i] = 0;
		}
		
		return arr;
	}
	
	public static int[] three(int[] arr) {
		for (int i = 1; i < N; i += 2) {
			if (arr[i] == 0) arr[i] = 1;
			else if (arr[i] == 1) arr[i] = 0;
		}
		
		return arr;
	}
	
	public static int[] four(int[] arr) {
		for (int i = 0; i < N; i += 3) {
			if (arr[i] == 0) arr[i] = 1;
			else if (arr[i] == 1) arr[i] = 0;
		}
		
		return arr;
	}

}
