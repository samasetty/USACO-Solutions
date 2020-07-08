/*
ID: settysa1
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;

public class crypt1 {
	static List<Integer> digits = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		
		// read data from file
		int numDigits = Integer.parseInt(f.readLine());
		StringTokenizer st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numDigits; i++)
			digits.add(Integer.parseInt(st.nextToken()));
		
		// perform calculations
		int counter = 0;
		for (int A : digits) {
			for (int B : digits) {
				for (int C : digits) {
					for (int D : digits) {
						for (int E : digits) {
							int ABC = (100 * A) + (10 * B) + C;
							int DE = (10 * D) + E;
							if ((val(ABC * E)) && (String.valueOf(ABC * E).length() == 3) 
								&& val(ABC * D) && (String.valueOf(ABC * D).length() == 3)
								&& val(ABC * DE) && (String.valueOf(ABC * DE).length() == 4)) {
								counter++;
								System.out.println(ABC + " * " + DE +  " = " + ABC * DE);
							}
						}
					}
				}
			}
		}
		
		out.println(counter);
		out.close();
		f.close();
	}
	
	public static boolean val(int num) {
		String sNum = String.valueOf(num);
		for (char c : sNum.toCharArray()) {
			if (!digits.contains(c - 48)) {
				return false;
			}
		}
		return true;
	}

}
