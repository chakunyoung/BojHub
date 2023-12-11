import java.io.*;
import java.util.*;

public class Main {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		p = new int[size + 1];
		for (int i = 1; i <= size; i++)
			p[i] = i;

		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

		for (int i = 1; i <= size; i++) {
			int cost = Integer.parseInt(br.readLine());
			pq.add(new Edge(0, i, cost));
		}

		for (int i = 1; i <= size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= size; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if (i != j) {
					pq.add(new Edge(i, j, cost));
				}
			}
		}

		int totalCost = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (find(edge.s) != find(edge.e)) {
				totalCost += edge.cost;
				union(edge.s, edge.e);
			}
		}

		System.out.println(totalCost);
	}

	static int find(int x) {
		if (x == p[x])
			return x;
		return p[x] = find(p[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	static class Edge {
		int s, e, cost;

		Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	}
}
