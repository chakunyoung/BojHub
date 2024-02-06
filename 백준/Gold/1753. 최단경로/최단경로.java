import java.util.*;
import java.io.*;

public class Main {

	static List<List<Node>> list = new ArrayList<>();
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		int nodes = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());

		dist = new int[nodes + 1];
		for (int i = 0; i <= nodes; i++) {
			list.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE / 2;
		} 

		int startNode = Integer.parseInt(br.readLine());
		dist[startNode] = 0;

		while (edges-- > 0) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.get(s).add(new Node(e, w));
		}

		dijk(startNode);

		for (int i = 1; i < list.size(); i++) {
			if (dist[i] == Integer.MAX_VALUE / 2)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void dijk(int startNode) {
		Queue<Node> q = new PriorityQueue<>((o1, o2 )->o1.w - o2.w);
		q.offer(new Node(startNode, 0));

		while (!q.isEmpty()) {
			Node mid = q.poll();

			if (mid.w > dist[mid.e])
				continue;

			for (Node dest : list.get(mid.e)) {
				if (dist[dest.e] > dist[mid.e] + dest.w) {
					dist[dest.e] = dist[mid.e] + dest.w;
					q.offer(new Node(dest.e, dist[dest.e]));
				}
			}
		}
	}

	static class Node {
		int e, w;

		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
}
