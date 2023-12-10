import java.util.*;
import java.io.*;

public class Main {

	static Queue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
	static List<List<Edge>> list = new ArrayList<>();
	static int[] p;
	static List<Edge> l = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/text"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());
		
		p = new int[nodeCount + 1];
		for(int i = 0; i<= nodeCount; i++)
			list.add(new ArrayList<>());
		
		for(int i = 0; i<p.length; i++) {
			p[i] = i;
		}
		
		while(edgeCount -- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			//list.get(s).add(new Edge(e, w));
			q.offer(new Edge(s,e,w));
		}
		
		while(!q.isEmpty()) {
			Edge edge = q.poll();
			
			if(union(edge.s, edge.e)) {
				l.add(edge);
			}
		}
		
		l.sort((o1,o2) -> o1.w-o2.w);
		
		long sum = 0;
		for(int i = 0; i<l.size() - 1; i++ ) 
			sum += l.get(i).w;
		
		System.out.println(sum);
		
	}

	public static int find(int n) {
		if (p[n] == n)
			return n;
		return p[n] = find(p[n]);
	}

	public static boolean union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		
		if(n1 == n2)
			return false;
		
		if(n1 > n2) 
			p[n1] = n2;
		else
			p[n2] = n1;
		
		return true;
		
	}

	static class Edge {
		int s, e, w;
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
	}
}
