/*
ID: settysa1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

public class milk {
	static LinkedHashMap<Integer, Integer> hashm = new LinkedHashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int req = Integer.parseInt(st.nextToken());
		int fNum = Integer.parseInt(st.nextToken());
		
		List<Farmer> farmerList = new ArrayList<Farmer>();
		for (int i = 0; i <fNum; i++) {
			st = new StringTokenizer(f.readLine());
			farmerList.add(new Farmer(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(farmerList, new Comparator<Farmer>() {
			public int compare(Farmer f1, Farmer f2) {
				return f1.price - f2.price;
			}
		});
		
		int have = 0;
		int moneySpent = 0;
		for (Farmer fr : farmerList) {
			if ((have + fr.amount) >= req) {
				int diff = req - have;
				moneySpent += diff * fr.price;
				have += diff;
				break;
			} else {
				have += fr.amount;
				moneySpent += fr.amount*fr.price;
			}
		}
		
		out.println(moneySpent);
		
		out.close();
		f.close();
	}
}

class Farmer {
	final int price;
	final int amount;
	Farmer(int price, int amount) {
		this.price = price;
		this.amount = amount;
	}
}
