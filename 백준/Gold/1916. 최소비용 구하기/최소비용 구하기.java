import java.util.*;
import java.io.*;

public class Main {
	
	static Queue<Node> q = new PriorityQueue<>((o1,o2) -> o1.dist - o2.dist);
	static List<List<Node>> list;
	static int[] dists;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int nodes = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i<=nodes; i++) list.add(new ArrayList<>());
		
		for(int i = 0; i<edges; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			list.get(s).add(new Node(e, dist));
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		dists = new int[nodes + 1];
		for(int i = 1; i<dists.length; i++) 
			dists[i] = Integer.MAX_VALUE>>1 ;
		dists[s] = 0;
		q.offer(new Node(s, 0));
		dijk();
		System.out.println(dists[e]);
	}
	public static void dijk() {
		while(!q.isEmpty()) {
			Node mid = q.poll();
			
			if(mid.dist > dists[mid.y])
				continue;
			
			for(Node dest : list.get(mid.y)) {
				if(dists[mid.y] + dest.dist < dists[dest.y]) {
					dists[dest.y] = dists[mid.y] + dest.dist;
					q.offer(new Node(dest.y, dists[mid.y] + dest.dist));
				}
			}
		}
	}

	static class Node {
		int y, dist;

		public Node(int y, int dist) {
			this.y = y;
			this.dist = dist;
		}
	}
}