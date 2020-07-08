/*
ID: settysa1
LANG: JAVA
TASK: milk2
 */
import java.io.*;
import java.util.*;

public class milk2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int intervals = Integer.parseInt(f.readLine());
		Interval[] intervalList = new Interval[intervals];
		StringTokenizer st;
		
		for (int i = 0; i < intervals; i++) {
			st = new StringTokenizer(f.readLine());
			intervalList[i] = new Interval(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(intervalList, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.start < i2.start)
					return -1;
				if (i1.start == i2.start)
					return 0;
				if (i1.start > i2.start)
					return 1;
				return 1;
			}
		});
		
		int curMax = 0;
		int curMin = 0;
		int min = intervalList[0].start;
		int max = intervalList[0].end;
		int milkGap = max - min;
		int idleGap = 0;
		
		for (Interval interval : intervalList) {
			curMin = interval.start;
			curMax = interval.end;
			milkGap = Math.max(milkGap, curMax - curMin);
			if (curMax > max) {
				if (curMin <= max) {
					max = curMax;
					milkGap = Math.max(milkGap, max - min);
				} else {
					idleGap = Math.max(idleGap, curMin - max);
					min = curMin;
					max = curMax;
					milkGap = Math.max(milkGap, curMax - curMin);
				}
			}
		}
		
		out.println(milkGap + " " + idleGap);
		out.close();
		f.close();
	}
}

class Interval {
	int start;
	int end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}