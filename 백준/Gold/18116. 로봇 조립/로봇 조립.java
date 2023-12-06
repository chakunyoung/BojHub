
import java.util.*;
import java.io.*;

/* TODO
 * 
 * 
 */

public class Main {
	
	static int[] p = new int[(int)Math.pow(10, 6) + 1];
	static int[] pSum = new int[(int)Math.pow(10, 6) + 1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<p.length; i++)
			p[i] = i;
		Arrays.fill(pSum, 1);
		
		int count = Integer.parseInt(br.readLine());
		
		while(count -- > 0) {
			st = new StringTokenizer(br.readLine());
			
			String o = st.nextToken();
			if(o.equals("I")) {
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				union(n1, n2);
			}else {
				sb.append(pSum[find(Integer.parseInt(st.nextToken()))]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int find(int n) {
		if(p[n] == n) 
			return n;
		return p[n] = find(p[n]);
	}
	
	public static boolean union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		
		if(n1 == n2)
			return false;
		
		// union
		if(n1 > n2) {
			p[n1] = n2;
			pSum[n2] += pSum[n1];
		}
		else {
			p[n2] = n1;
			pSum[n1] += pSum[n2];
		}
		return true;
	}
}

