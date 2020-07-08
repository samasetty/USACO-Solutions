/*
ID: settysa1
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;

public class barn1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		
		List<Integer> stalls = new ArrayList<Integer>();
		List<Integer> intervals = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(f.readLine());
		int maxBoards = Integer.parseInt(st.nextToken());
		int numStalls = Integer.parseInt(st.nextToken());
		int occupied = Integer.parseInt(st.nextToken());
		
		// read data from file
		for (int i = 1; i < occupied + 1; i++) {
			stalls.add(Integer.parseInt(f.readLine()));
		}
		Collections.sort(stalls);
		
		// get intervals (gaps)
		int curVal, afterVal;
		for (int i = 0; i < occupied - 1; i++) {
			curVal = stalls.get(i);
			afterVal = stalls.get(i + 1);
			if ((curVal + 1) != afterVal) {
				intervals.add(afterVal - curVal - 1);
			}
		}
		
		// recursion sequence
		int stallsCovered = ((maxBoards == 0) ? 0 : 
			stalls.get(stalls.size() - 1) - stalls.get(0) + 1);
		for (int i = 0; i < maxBoards - 1; i++) {
			if (intervals.isEmpty()) {
				break;
			}
			if (maxBoards == 0) {
				stallsCovered = 0;
				break;
			}
			int maxInterval = Collections.max(intervals);
			intervals.remove(Integer.valueOf(maxInterval));
			stallsCovered -= maxInterval;
			
		}
		
		out.println(stallsCovered);
		out.close();
		f.close();
	}
}
