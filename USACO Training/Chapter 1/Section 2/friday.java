/*
ID: settysa1
LANG: JAVA
PROG: friday
*/
import java.io.*;
import java.util.*;

public class friday {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int[] dayCount = new int[7];
		Arrays.fill(dayCount, 0);
		// Sat, Sun, Mon, Tues, Weds, Thurs, Fri
		
		int[] regYear = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] leapYear = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		int endYr = Integer.parseInt(f.readLine()) + 1900;
		int totalDays = 2;
		int thirteenth = 0;
		
		for (int curYr = 1900; curYr < endYr; curYr++) {
			if (isLeapYr(curYr)) {
				for (int curMonth = 0; curMonth < leapYear.length; curMonth++) {
					thirteenth = (totalDays + 12) % 7;
					dayCount[thirteenth]++;
					totalDays += leapYear[curMonth];
				}
			} else {
				for (int curMonth = 0; curMonth < regYear.length; curMonth++) {
					thirteenth = (totalDays + 12) % 7;
					dayCount[thirteenth]++;
					totalDays += regYear[curMonth];
				}
				continue;
			}
		}
		for (int day = 0; day < dayCount.length; day++) {
			if (day != dayCount.length - 1)
				out.print(dayCount[day] + " ");
			else out.print(dayCount[day]+"\n");
		}
		
		out.close();
		f.close();	
	}
	
	public static boolean isLeapYr(int year) {
		if (year % 100 == 0)
			return (year % 400 == 0);
		return (year % 4 == 0);
	}
}