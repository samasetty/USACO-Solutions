/*
ID: settysa1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

public class palsquare {
	static int base;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		base = Integer.parseInt(f.readLine());
		
		int[] base10Digits = new int[300];
		int[] base10Squares = new int[300];
		String[] baseNDigits = new String[300];
		String[] baseNSquares = new String[300];
		char[] key = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
		
		for (int i = 1; i < 301; i++) {
			base10Digits[i - 1] = i;
			base10Squares[i - 1] = (int) Math.pow(i, 2);
			
			convertToN(baseNDigits, i - 1, i, new StringBuilder(), key);
			convertToN(baseNSquares, i - 1, (int) Math.pow(i,  2), new StringBuilder(), key);
			
			if (isPalindrome(baseNSquares[i - 1])) {
				out.println(baseNDigits[i - 1] + " " + baseNSquares[i - 1]);
			}
		} System.out.println(Arrays.toString(baseNDigits));
		
		out.close();
		f.close();
	}
	
	public static void convertToN(String[] arr, int indexVal, int num, StringBuilder sb, char[] key) {
		int quotient;
		int remainder;
		if (num != 0) {
			quotient = num / base;
			remainder = num % base;
			if (remainder > 9) // if base 11 or higher
				convertToN(arr, indexVal, quotient, new StringBuilder(sb).insert(0, key[remainder - 10]), key);
			else convertToN(arr, indexVal, quotient, new StringBuilder(sb).insert(0, remainder), key);
		} else {
		arr[indexVal] = sb.toString(); }
	}
	
	public static boolean isPalindrome(String num) {
		StringBuilder str = new StringBuilder(num);
		str = str.reverse();
		
		if (num.equals(str.toString()))
			return true;
		return false;
	}
}
