/*
ID: settysa1
LANG: JAVA
PROG: ride
*/
import java.io.*;
import java.util.*;

public class ride {

	public static void main(String[] args) throws IOException {		
	    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
	    if (findTotal(new StringTokenizer(f.readLine()).nextToken()) == 
	    		findTotal(new StringTokenizer(f.readLine()).nextToken())) {
	    	out.println("GO");
	    } else {
	    	out.println("STAY");
	    }
	    out.close();
	    f.close();
	}
	
	public static int getVal(char c) {
		return ((c - 'A') + 1);
	}
	
	public static int findTotal(String s) {
		int result = 1;
		char[] c = s.toCharArray();
		for (char ch : c) {
			result *= getVal(ch);
		}
		return (result % 47);
	}

}
