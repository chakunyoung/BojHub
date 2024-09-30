import java.util.*;
import java.io.*;

public class Main {

	static int[] dist;
	static int[] arr;
	static List<List<Edge>> list;
	static List<Integer> f = new ArrayList<>();

	static StringBuilder sb1 = new StringBuilder();
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int city = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		dist = new int[city + 1];
		arr = new int[city + 1];

		list = new ArrayList<>();
		for (int i = 0; i <= city; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < bus; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(s).add(new Edge(e, w));
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		Arrays.fill(dist, Integer.MAX_VALUE >> 1);
		dist[s] = 0; // !!

		dijk(s);
		recur(e);

		System.out.println(dist[e]);
		System.out.println(count);

		Collections.reverse(f);
		for (int ele : f) {
			sb1.append(ele).append(" ");
		}
		System.out.println(sb1.toString());

	}

	static void dijk(int s) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.w - o2.w;
		});

		pq.offer(new Edge(s, 0));

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			if (dist[edge.e] < edge.w)
				continue;

			for (Edge e : list.get(edge.e)) {
				if (dist[edge.e] + e.w < dist[e.e]) {
					pq.offer(new Edge(e.e, dist[edge.e] + e.w));
					dist[e.e] = dist[edge.e] + e.w; // !!
					arr[e.e] = edge.e;
				}
			}
		}
	}

	static void recur(int n) {
		if (arr[n] == n)
			return;

		f.add(n);
		count++;

		recur(arr[n]);
	}

	static class Edge {
		int e;
		int w;

		Edge(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
}