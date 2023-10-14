import java.util.*;
import java.io.*;

class Main {

	static List<List<Integer>> list;
	static List<Integer> want = new ArrayList<>();
	static List<Integer> temp = new ArrayList<>();
	static int cost = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sbb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		list = new ArrayList<>();

		int size = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			want.add(Integer.parseInt(st.nextToken()));

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new ArrayList<>());
			while (st.hasMoreTokens())
				list.get(i).add(Integer.parseInt(st.nextToken()));
		}

		recur(size, 0, 0, new int[4]);
		
		if(cost == Integer.MAX_VALUE) {
			System.out.println("-1");
			return;
		}
		System.out.println(cost);
		System.out.println(sb);
	}

	public static void recur(int limit, int n, int cCost, int[] cValue) {
		if(cCost > cost) return; 
		
		if (n == limit) {
			for (int k = 0; k < 4; k++) {
				if (want.get(k) > cValue[k])
					return;
			}
			
			sbb.setLength(0);
			for (int i = 0; i < temp.size(); i++) {
				sbb.append(temp.get(i) + 1).append(" ");
			}
			
			if(cost > cCost || (cost == cCost && sb.toString().compareTo(sbb.toString()) > 0)) {
				cost = cCost;
				sb.setLength(0);
				sb.append(sbb);
			}
			return;
		}

		recur(limit, n + 1, cCost, cValue);
		temp.add(n);
		int nCost = cCost + list.get(n).get(4);
		int[] nValue = cValue.clone();
		for(int i=0; i<4; i++) {
			nValue[i] += list.get(n).get(i);
		}
		recur(limit, n + 1, nCost, nValue);
		temp.remove(temp.size() - 1);
	}
}
