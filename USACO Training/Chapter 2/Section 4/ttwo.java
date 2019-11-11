/*
ID: settysa1
LANG: JAVA
TASK: ttwo
*/

import static java.lang.Math.max;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ttwo {
	static int cowX, cowY, cowDir;
	static int fmrX, fmrY, fmrDir;
	static int[] deltX = new int[] {0, 1, 0, -1};
	static int[] deltY = new int[] {-1, 0, 1, 0};
	static char[][] key = new char[10][10];

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")),true);
		String st;
		
		for (int i = 0; i < 10; i++) {
			st = f.readLine();
			for (int j = 0; j < 10; j++) {
				key[i][j] = st.charAt(j);
				if (st.charAt(j) == 'F') {
					fmrX = j;
					fmrY = i;
					fmrDir = 0;
				} else if (st.charAt(j) == 'C') {
					cowX = j;
					cowY = i;
					cowDir = 0;
				}
			}
		}
		
		for (int i = 1; i <= 160000; i++) {
			//System.out.println("cowX " + cowX + " cowY " + cowY);
			//System.out.println("deltY " + deltY[cowDir] + " deltX " + deltX[cowDir]);
			//System.out.println("x:" + (cowX + deltX[cowDir]) + "  y:" + (cowY + deltY[cowDir]));
			
			// move cow
			if (cowX + deltX[cowDir] < 0 || cowX + deltX[cowDir] > 9 ||
					cowY + deltY[cowDir] < 0 || cowY + deltY[cowDir] > 9 ||
					key[cowY + deltY[cowDir]][cowX + deltX[cowDir]] == '*') {
				//System.out.println(key[cowY + deltY[cowDir]][cowX + deltX[cowDir]]);
				cowDir = (cowDir + 1) % 4;
			} else {
				cowX = cowX + deltX[cowDir];
				cowY = cowY + deltY[cowDir];
			}
			
			//System.out.println("fmrX " + fmrX + " fmrY " + fmrY);
			//System.out.println(fmrDir);
			//System.out.println(fmrY + deltY[fmrDir]);
			// move farmer
			if (fmrX + deltX[fmrDir] < 0 || fmrX + deltX[fmrDir] > 9 ||
					fmrY + deltY[fmrDir] < 0 || fmrY + deltY[fmrDir] > 9 || 
					key[fmrY + deltY[fmrDir]][fmrX + deltX[fmrDir]] == '*') {
				fmrDir = (fmrDir + 1) % 4;
				
			} else {
				fmrX = fmrX + deltX[fmrDir];
				fmrY = fmrY + deltY[fmrDir];
			}
			
			// check if they are in same location
			if (cowX == fmrX && cowY == fmrY) {
				out.println(i);
				System.exit(0);
			}
			
			//System.out.println("COWx: " + cowX + " COWy: " + cowY);
		}
		
		out.println(0);
		out.close();
		f.close();
	}

}
