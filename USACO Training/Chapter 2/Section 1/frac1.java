/*
ID: settysa1
LANG: JAVA
TASK: frac1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class frac1 {
	static int n;
	static ArrayList<Fraction> fracs;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")),true);
		n = Integer.parseInt(f.readLine());
		//n = 160; 
		fracs = new ArrayList<Fraction>();
		
		// generating our fractions
		fracs.add(new Fraction());
		fracs.add(new Fraction(1, 1));
		
		Fraction b;
		for (int i = 2; i < n + 1; i++) {
			b = new Fraction(0, i);
			for (int j = 0; j < i - 1; j++) {
				b.add();
				if (b.reduced()) fracs.add(b.copyOf());
			}
		}
		
		Collections.sort(fracs);
		
		for (Fraction fra : fracs) {
			out.println(fra);
		}
		
		out.close();
		f.close();
	}
}

class Fraction implements Comparable<Fraction> {
	int numerator;
	int denominator;
	
	public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int num, int denom) {
        numerator = num;
        denominator = denom;
    }

    public void add() {
        numerator = numerator + 1;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean equals(Fraction rhs) {
        return (numerator == rhs.numerator) && (denominator == rhs.denominator);
    }

    public boolean reduced() {
		for (int i = 2; i <= numerator; i++) {
			if (numerator % i == 0 && denominator % i == 0) return false;
		}
		return true;
	}

	@Override
	public int compareTo(Fraction o) {
		if(denominator == o.denominator) {
			if (numerator < o.numerator) {
				return -1;
			} else if (numerator > o.numerator) {
				return 1;
			} else { return 0; }
		}
		
		if (numerator * o.denominator > o.numerator * denominator) {
			return 1;
		} else if (numerator * o.denominator < o.numerator * denominator) {
			return -1;
		} else { return 0; }
	}
	
	public Fraction copyOf() {
		return new Fraction(numerator, denominator);
	}
}