/*
ID: settysa1
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

public class combo {
	static int numDigits;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		
		// data structures
		List<Integer> fjC = new ArrayList<Integer>();
		List<Integer> masterC = new ArrayList<Integer>();
		
		// read data from file
		numDigits = Integer.parseInt(f.readLine());
		StringTokenizer st1 = new StringTokenizer(f.readLine());
		StringTokenizer st2 = new StringTokenizer(f.readLine());
		
		// create combination lists
		for (int i = 0; i < 3; i++) {
			fjC.add(Integer.parseInt(st1.nextToken()));
			masterC.add(Integer.parseInt(st2.nextToken()));
		}
		
		// find options
		List<Integer> fj0 = options(fjC.get(0));
		List<Integer> fj1 = options(fjC.get(1));
		List<Integer> fj2 = options(fjC.get(2));
		
		List<Integer> m0 = options(masterC.get(0));
		List<Integer> m1 = options(masterC.get(1));
		List<Integer> m2 = options(masterC.get(2));
		
		// run everything through
		List<Integer> values;
		int counter = 0;
		for (int i = 1; i < numDigits + 1; i++) {
			for (int j = 1; j < numDigits + 1; j++) {
				for (int k = 1; k < numDigits + 1; k++) {
					values = new ArrayList<Integer>();
					values.add(i); values.add(j); values.add(k);
					if (matches(fj0, fj1, fj2, m0, m1, m2, values))
						counter++;
				}
			}
		}
		
		out.println(counter);
		out.close();
		f.close();
	}
	
	public static boolean matches(List<Integer> fj0, List<Integer> fj1, List<Integer> fj2,
			List<Integer> m0, List<Integer> m1, List<Integer> m2, List<Integer> combo) {
		if ( ((fj0.contains(combo.get(0))) && (fj1.contains(combo.get(1))) && 
				(fj2.contains(combo.get(2)))) || ((m0.contains(combo.get(0))) && 
				(m1.contains(combo.get(1))) && (m2.contains(combo.get(2)))) ) {
			return true;
		}
		return false;
	}
	
	public static List<Integer> options(int dial) {
		List<Integer> choices = new ArrayList<Integer>();
		int val;
		
		// unusual cases
		if (numDigits == 1) {
			choices.add(1); return choices; }
		if (numDigits == 2) {
			choices.add(1); choices.add(2); return choices; }
		if (numDigits == 3) {
			choices.add(1); choices.add(2); choices.add(3); return choices; }
		if (numDigits == 4) {
			choices.add(1); choices.add(2); choices.add(3); choices.add(4); return choices; }
		if (numDigits == 5) {
			choices.add(1); choices.add(2); choices.add(3); choices.add(4); 
			choices.add(5); return choices; }
	
		// normal cases
		for (int i = -2; i < 3; i++) {
			if ((dial + i) <= 0) {
				val = (numDigits + (dial + i));
			} else if ((dial + i) > numDigits) {
				val = (dial - numDigits) + i;
			} else {
				val = dial + i;
			}
			choices.add(val);
		}
		return choices;
	}

}
