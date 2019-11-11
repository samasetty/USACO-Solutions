/*
ID: settysa1
LANG: JAVA
TASK: contact
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import static java.lang.Math.max;

public class contact {
	static int A;
	static int B;
	static int N;
	
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("contact.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = f.readLine()) != null)
            sb.append(line);

        int len = sb.length();
        int[] totals = new int[ (int) Math.pow(2, B+1) ];

        for (int i = A; i <= B; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = j; k <= len-i; k+=i) {
                    int range = Integer.parseInt("1" + sb.substring(k, k+i), 2);
                    totals[range]++;
                }
            }
        }
        
        int max = 0;
        for (int i = 2; i < totals.length; i++) {
            if (totals[i]>max) {
                max=totals[i];
            }
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            results.add(new ArrayList<Integer>());
        }
        for (int i = (int)Math.max(2, Math.pow(2, A)); i < totals.length; i++) {
            results.get(totals[i]).add(i);
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
        int totalPrinted = 0;
        for (int i = max; i > 0; i--) {
            if (totalPrinted>=N) {
                break;
            }
            if (results.get(i).size()==0) {
                continue;
            }

            totalPrinted++;
            out.println(i);
            for (int j = 0; j < results.get(i).size(); j++) {
                out.print(Integer.toString(results.get(i).get(j), 2).substring(1));
                if (j%6==5 && j+1 != results.get(i).size()) {
                    out.println();
                    continue;
                }
                if (j < results.get(i).size()-1) {
                    out.print(" ");
                }
            }
            out.println();
        }
        out.close();
    }
}