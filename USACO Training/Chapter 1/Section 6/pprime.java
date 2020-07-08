/*
ID: settysa1
LANG: JAVA
TASK: pprime
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Math.max;

public class pprime {
	static int lo;
	static int hi;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")),true);
		StringTokenizer st = new StringTokenizer(f.readLine());
		lo = Integer.parseInt(st.nextToken());
		hi = Integer.parseInt(st.nextToken());
		
		gen();
		
		out.close();
		f.close();
	}
	
	public static void gen() {
		// one digit
		if (3 >= lo && 3 <= hi) out.println(3);
		if (5 >= lo && 5 <= hi) out.println(5);
		if (7 >= lo && 7 <= hi) out.println(7);
		
		// 11 is the only two digit palindrome
		if (11 >= lo && 11 <= hi) out.println(11);
		
		// three digits
		for (int d1 = 1; d1 < 10; d1 += 2) {
			for (int d2 = 0; d2 < 10; d2++) {
				
				if (isPrime(100 * d1 + 10 * d2 + d1) &&  100 * d1 + 10 * d2 + d1 >= lo && 100 * d1 + 10 * d2 + d1 <= hi) 
					out.println(100 * d1 + 10 * d2 + d1);
			}
		}
		
		// four digits
		for (int d1 = 1; d1 < 10; d1 += 2) {
			for (int d2 = 0; d2 < 10; d2++) {
				
				if (isPrime(1000 * d1 + 100 * d2 + 10 * d2 + d1) && 1000 * d1 + 100 * d2 + 10 * d2 + d1 >= lo && 1000 * d1 + 100 * d2 + 10 * d2 + d1 <= hi) 
					out.println(1000 * d1 + 100 * d2 + 10 * d2 + d1);
			}
		}
		
		// five digits
		for (int d1 = 1; d1 < 10; d1 += 2) {
			for (int d2 = 0; d2 < 10; d2++) {
				for (int d3 = 0; d3 < 10; d3++) {
					
					if (isPrime(10000 * d1 + 1000 * d2 + 100 * d3 + 10 * d2 + d1) && 10000 * d1 + 1000 * d2 + 100 * d3 + 10 * d2 + d1 >= lo && 10000 * d1 + 1000 * d2 + 100 * d3 + 10 * d2 + d1 <= hi) 
						out.println(10000 * d1 + 1000 * d2 + 100 * d3 + 10 * d2 + d1);
					
				}
			}
		}
		
		// six digits
		for (int d1 = 1; d1 < 10; d1 += 2) {
			for (int d2 = 0; d2 < 10; d2++) {
				for (int d3 = 0; d3 < 10; d3++) {
					
					if (isPrime(100000 * d1 + 10000 * d2 + 1000 * d3 + 100 * d3 + 10 * d2 + d1) && 100000 * d1 + 10000 * d2 + 1000 * d3 + 100 * d3 + 10 * d2 + d1 >= lo && 100000 * d1 + 10000 * d2 + 1000 * d3 + 100 * d3 + 10 * d2 + d1 <= hi) 
						out.println(100000 * d1 + 10000 * d2 + 1000 * d3 + 100 * d3 + 10 * d2 + d1);
					
				}
			}
		}
		
		// seven digits
		for (int d1 = 1; d1 < 10; d1 += 2) {
			for (int d2 = 0; d2 < 10; d2++) {
				for (int d3 = 0; d3 < 10; d3++) {
					for (int d4 = 0; d4 < 10; d4++) {
						
						if (isPrime(1000000 * d1 + 100000 * d2 + 10000 * d3 + 1000 * d4 + 100 * d3 + 10 * d2 + d1) && 1000000 * d1 + 100000 * d2 + 10000 * d3 + 1000 * d4 + 100 * d3 + 10 * d2 + d1 >= lo && 1000000 * d1 + 100000 * d2 + 10000 * d3 + 1000 * d4 + 100 * d3 + 10 * d2 + d1 <= hi) 
							out.println(1000000 * d1 + 100000 * d2 + 10000 * d3 + 1000 * d4 + 100 * d3 + 10 * d2 + d1);
					
					}
				}
			}
		}
		
		// eight digits
		for (int d1 = 1; d1 < 10; d1 += 2) {
			for (int d2 = 0; d2 < 10; d2++) {
				for (int d3 = 0; d3 < 10; d3++) {
					for (int d4 = 0; d4 < 10; d4++) {
						
						if (isPrime(10000000 * d1 + 1000000 * d2 + 100000 * d3 + 10000 * d4 + 1000 * d4 + 100 * d3 + 10 * d2 + d1) && 10000000 * d1 + 1000000 * d2 + 100000 * d3 + 10000 * d4 + 1000 * d4 + 100 * d3 + 10 * d2 + d1 >= lo && 10000000 * d1 + 1000000 * d2 + 100000 * d3 + 10000 * d4 + 1000 * d4 + 100 * d3 + 10 * d2 + d1 <= hi) 
							out.println(10000000 * d1 + 1000000 * d2 + 100000 * d3 + 10000 * d4 + 1000 * d4 + 100 * d3 + 10 * d2 + d1);
					
					}
				}
			}
		}	
	}
	
	public static boolean isPrime(int num) {
		if (num % 2 == 0) return false;
		if (num == 2) return true;
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0) return false;
		}
		
		return true;
	}

}
