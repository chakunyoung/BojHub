import java.io.*;
import java.util.*;

public class Main {
	static int N, M, A, B;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		long[] distA = dijkstra(A);
		long[] distB = dijkstra(B);
		long total = distA[B];

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (distA[i] + distB[i] == total) {
				list.add(i);
			}
		}

		sb.append(list.size()).append("\n");
		list.stream().sorted().forEach(n -> sb.append(n).append(" "));
		System.out.println(sb.toString());
	}

	public static long[] dijkstra(int start) {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dis, o2.dis));
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (dist[node.id] < node.dis)
				continue;

			for (Node next : graph.get(node.id)) {
				long nextDist = dist[node.id] + next.dis;
				if (nextDist < dist[next.id]) {
					dist[next.id] = nextDist;
					pq.add(new Node(next.id, nextDist));
				}
			}
		}

		return dist;
	}

	static class Node {
		int id;
		long dis;

		public Node(int id, long dis) {
			this.id = id;
			this.dis = dis;
		}
	}

}
