/*
ID: settysa1
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;

public class transform {
	static int patternSize;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		
		patternSize = Integer.parseInt(f.readLine());
		final char[][] patternDesign = new char[patternSize][patternSize];
		final char[][] patternTransformed = new char[patternSize][patternSize];
		for (int i = 0; i < patternSize; i++) {
			patternDesign[i] = f.readLine().toCharArray();
		}
		for (int i = 0; i < patternSize; i++) {
			patternTransformed[i] = f.readLine().toCharArray();
		}
		
		if (Arrays.deepEquals(ninetyRotation(patternDesign), patternTransformed)) {
			System.out.println("?");
		      out.println(1);
		} else if (Arrays.deepEquals(oneEightyRotation(patternDesign), patternTransformed)) {
		      out.println(2);
		} else if (Arrays.deepEquals(twoSeventyRotation(patternDesign), patternTransformed)) {
		      out.println(3);
		} else if (Arrays.deepEquals(reflect(patternDesign), patternTransformed)) {
		      out.println(4);
		} else if ( (Arrays.deepEquals(ninetyRotation(reflect(patternDesign)), patternTransformed)) || 
				(Arrays.deepEquals(oneEightyRotation(reflect(patternDesign)), patternTransformed)) || 
				(Arrays.deepEquals(twoSeventyRotation(reflect(patternDesign)), patternTransformed)) ) {
		      out.println(5);
		} else if (Arrays.deepEquals(patternDesign, patternTransformed)) {
			out.println(6);
		} else {
			out.println(7);
		}
		
		out.close();
		f.close();
	}
	
	static char[][] ninetyRotation(char[][] squares) {
		char[][] degree90 = new char[patternSize][patternSize];
		for (int i = 0; i < patternSize; i++) {
			for (int x = patternSize - 1; x >= 0; x--) {
				degree90[i][(patternSize - 1) - x] = squares[x][i];
		    }
		}
		return degree90;
	}
	
	static char[][] oneEightyRotation(char[][] squares) {
		char[][] degree180 = new char[patternSize][patternSize];
	    for (int i = patternSize - 1; i >= 0; i--) {
	      for (int x = patternSize - 1; x >= 0; x--) {
	        degree180[(patternSize - 1) - i][(patternSize - 1) - x] = squares[i][x];
	      }
	    }
	    return degree180;
	}
	
	static char[][] twoSeventyRotation(char[][] squares) {
		char[][] degree270 = new char[patternSize][patternSize];
	    for (int i = patternSize - 1; i >= 0; i--) {
	      for (int x = 0; x < patternSize; x++) {
	        degree270[(patternSize - 1) - i][x] = squares[x][i];
	      }
	    }
	    return degree270;
	}
	
	static char[][] reflect(char[][] squares) {
		char[][] reflection = new char[patternSize][patternSize];
	    for (int i = 0; i < patternSize; i++) {
	      for (int x = patternSize - 1; x >= 0; x--) {
	        reflection[i][(patternSize - 1) - x] = squares[i][x];
	      }
	    }
	    return reflection;
	}
	
	
	
}
