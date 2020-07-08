/*
ID: settysa1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

public class dualpal {
	static String var;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		char[] key = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
		int num = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		
		int palCounter = 0;
		int cur = min + 1;
		while (palCounter != num) {
			if (twoOrMore(cur, key)) {
				out.println(cur);
				palCounter++;
			}
			cur++;
		}
		
		out.close();
		f.close();
	}
	
	public static boolean isPalindrome(String num) {
		StringBuilder str = new StringBuilder(num);
		str = str.reverse();
		
		if (num.equals(str.toString()))
			return true;
		return false;
	}
	
	public static void convertToN(int base, int num, StringBuilder sb, char[] key) {
		int quotient;
		int remainder;
		if (num != 0) {
			quotient = num / base;
			remainder = num % base;
			if (remainder > 9) // if base 11 or higher
				convertToN(base, quotient, new StringBuilder(sb).insert(0, key[remainder - 10]), key);
			else convertToN(base, quotient, new StringBuilder(sb).insert(0, remainder), key);
		} else {
		var = sb.toString(); }
	}
	
	public static boolean twoOrMore(int num, char[] key) {
		int palCount = 0;
		for (int i = 2; i <= 10; i++) {
			convertToN(i, num, new StringBuilder(), key);
			if (isPalindrome(var))
				palCount++;
			if (palCount == 2) {
				return true;
			}
		}
		return false;
	}
}
