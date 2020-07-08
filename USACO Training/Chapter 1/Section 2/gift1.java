/*
ID: settysa1
LANG: JAVA
PROG: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		int numPeople = Integer.parseInt(f.readLine());
		LinkedHashMap<String, Integer> friendGroup = new LinkedHashMap<String, Integer>(numPeople);
		// Setting initial values of $0 for each individual
		for (int i = 0; i < numPeople; i++) {
			friendGroup.put(f.readLine(), 0);
		}
		StringTokenizer st = new StringTokenizer("");
		for (int i = 0; i < numPeople; i++) {
			String giver = new String(f.readLine());
			
			st = new StringTokenizer(f.readLine());
			int totalMoney = Integer.parseInt(st.nextToken());    // first integer
		    int divideAmong = Integer.parseInt(st.nextToken());   // second integer
		    // if dividing amongst positive number of people:
		    if (divideAmong > 0) {
		    	friendGroup.put(giver, friendGroup.get(giver) - totalMoney + (totalMoney % divideAmong));
				for (int x = 0; x < divideAmong; x++) {	
					String individual = new String(f.readLine());
					friendGroup.put(individual, friendGroup.get(individual) + (totalMoney / divideAmong));
				}
		    }
		}
		System.out.println(friendGroup);
		for (String key : friendGroup.keySet()) {
			out.print(key + " " + friendGroup.get(key));
			out.println();
		}
		
		out.close();
		f.close();

	}

}
