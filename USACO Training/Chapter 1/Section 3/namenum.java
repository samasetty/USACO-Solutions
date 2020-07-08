/*
ID: settysa1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;


public class namenum {
	static final char[][] cowKey = {
			{}, {}, {'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'},
			{'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'},
			{'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'} 
	};
	static int CNT;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		
		char[][] cowKey = {
				{}, {}, {'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'},
				{'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'R', 'S'},
				{'T', 'U', 'V'}, {'W', 'X', 'Y'} 
		};
		String ID = f.readLine();
		String[] dict = readDictionary(new String[4617]);
		test(0, ID, new StringBuilder(), cowKey, dict, out);
		
		if (CNT == 0) out.println("NONE");
		out.close();
		f.close();
		
	}
	
	public static void test(int index, String digits, StringBuilder sb, char[][] keypad, 
			String[] dict, PrintWriter pw) {
		if (sb.length() != digits.length()) {
			int key = Integer.parseInt(digits.charAt(index) + "");
			for (int m = 0; m < keypad[key].length; m++) {
				test(index + 1, digits, new StringBuilder(sb).append(
						keypad[key][m]), keypad, dict, pw);
			}
		} else {
			String s = sb.toString();
			if (Arrays.binarySearch(dict, s) > 0) {
				pw.println(s);
				CNT++;
			}
		}
	}
	
	public static String[] readDictionary(String[] dict) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("dict.txt"));
		String tmp;
		int i = 0;
		while ((tmp = r.readLine()) != null) {
			dict[i] = tmp; i++;
		}
		r.close();
		return dict;
	}
}