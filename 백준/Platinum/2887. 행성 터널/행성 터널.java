import java.io.*;
import java.util.*;

public class Main {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());

		List<Planet> list = new ArrayList<>();
		Planet[][] sortedArr = new Planet[3][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			Planet p = new Planet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), i);

			list.add(p);
			sortedArr[0][i] = p;
			sortedArr[1][i] = p;
			sortedArr[2][i] = p;
		}

		p = new int[size];
		for (int i = 0; i < size; i++)
			p[i] = i;

		Arrays.sort(sortedArr[0], (o1, o2) -> o1.x - o2.x);
		Arrays.sort(sortedArr[1], (o1, o2) -> o1.y - o2.y);
		Arrays.sort(sortedArr[2], (o1, o2) -> o1.z - o2.z);

		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < size - 1; j++) {
				Planet selected = sortedArr[i][j];
				Planet next = sortedArr[i][j + 1];
				int cost = (i == 0) ? Math.abs(selected.x - next.x)
						: (i == 1) ? Math.abs(selected.y - next.y) : Math.abs(selected.z - next.z);
				pq.offer(new Edge(selected.idx, next.idx, cost));
			}
		}

		int connected = 0;
		long ans = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (union(edge.s, edge.e)) {
				ans += edge.cost;
				++connected;
			}
			if (connected == size - 1)
				break;
		}

		System.out.println(ans);

	}

	static int find(int n) {
		if (p[n] == n)
			return n;
		return p[n] = find(p[n]);
	}

	static boolean union(int n1, int n2) {
		int dn1 = find(n1);
		int dn2 = find(n2);
		if (dn1 == dn2) {
			return false;
		}
		if (dn1 > dn2)
			p[dn2] = dn1;
		else
			p[dn1] = dn2;

		return true;

	}

	static class Planet {
		int x, y, z, idx;

		public Planet(int x, int y, int z, int idx) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}
	}

	static class Edge {
		int s, e, cost;

		public Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	}
}
