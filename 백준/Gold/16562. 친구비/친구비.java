
import java.util.*;
import java.io.*;

/* TODO
 * 모든 그래프의 그룹을 구해놓고, 
 * 그 그룹중의 가장 적은 비용의 친구를 소비
 */

public class Main {

	static int[] costs;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int friendCount = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());
		int hasCost = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		p = new int[friendCount + 1];
		costs = new int[friendCount + 1];
		
		for(int i = 1; i<friendCount + 1; i++)
			costs[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<friendCount + 1; i++)
			p[i] = i;
		
		while(edges -- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			
			union(f1,f2);
		}
		
		
		
		Set<Integer> s = new HashSet<>();
		int usedCost = 0;
		
		for(int i = 1; i<p.length; i++) {
			int n = find(i);
			if(!s.contains(n)) {
				s.add(n);
				usedCost += costs[n];
			}
		}
		
		//System.out.println(Arrays.toString(costs));
		//System.out.println(Arrays.toString(p));
		
		System.out.println(usedCost > hasCost ? "Oh no" : usedCost);
		
	}

	public static int find(int friend) {
		if(friend == p[friend]) 
			return friend;
		return p[friend] = find(p[friend]);
	}

	public static boolean union(int f1, int f2) {
		int f1p = find(f1);//..
		int f2p = find(f2);

		if(f1p == f2p) 
			return false;
		
//		* 비용이 적은 친구를 해당 그룹의 대표로 둔다.
		if(costs[f1p] > costs[f2p]) {
			p[f1p] = f2p;
		}else if(costs[f1p] < costs[f2p]) { 
			p[f2p] = f1p;
		}else { // 비용이 같을 때는, 번호가 작은 친구가 대표가 된다.
			if(f1p > f2p) {
				p[f1p] = f2p;
			}else {
				p[f2p] = f1p;
			}
		}
		return true;
	}
}
