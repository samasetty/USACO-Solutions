/*
ID: settysa1
LANG: JAVA
TASK: sprime
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

public class sprime {
	static int d;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")),true);
		d = Integer.parseInt(f.readLine());
		findSuperPrimes(2, 1);
		findSuperPrimes(3, 1);
		findSuperPrimes(5, 1);
		findSuperPrimes(7, 1);
		
		out.close();
		f.close();

	}
	
	public static boolean isPrime(int num) {
		if (num % 2 == 0) return false;
		if (num == 2) return true;
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0) return false;
		}
		
		return true;
	}
	
	public static void findSuperPrimes(int num, int digits) {
		if (digits == d) {
			out.println(num);
			return;
		}
		
		int newNum = 10 * num;
		if (isPrime(newNum + 1))
			findSuperPrimes(newNum + 1, digits + 1);
		if (isPrime(newNum + 3))
			findSuperPrimes(newNum + 3, digits + 1);
		if (isPrime(newNum + 7))
			findSuperPrimes(newNum + 7, digits + 1);
		if (isPrime(newNum + 9))
			findSuperPrimes(newNum + 9, digits + 1);
	}

}
