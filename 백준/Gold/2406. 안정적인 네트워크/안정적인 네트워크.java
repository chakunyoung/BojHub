import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(find(a), find(b));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (i == 0)
					continue;
				int cost = Integer.parseInt(st.nextToken());
				if (i < j) {
					pq.offer(new Edge(i + 1, j + 1, cost));
				}
			}
		}

		int totalCost = 0;
		ArrayList<Edge> list = new ArrayList<>();

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);
				totalCost += edge.cost;
				list.add(edge);
			}
		}

		System.out.println(totalCost + " " + list.size());
		for (Edge e : list) {
			System.out.println(e.s + " " + e.e);
		}
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
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
