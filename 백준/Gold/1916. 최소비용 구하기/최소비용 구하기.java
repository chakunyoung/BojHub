import java.util.*;
import java.io.*;

public class Main {

	static Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
	static List<List<Node>> list;
	static int[] dists;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int nodes = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for (int i = 0; i <= nodes; i++)
			list.add(new ArrayList<>());

		for (int i = 0; i < edges; i++) {
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
		Arrays.fill(dists, Integer.MAX_VALUE >> 1);
		dists[s] = 0;
		q.offer(new Node(s, 0));
		dijk();
		System.out.println(dists[e]);
	}

	public static void dijk() {
		while (!q.isEmpty()) {
			Node mid = q.poll();

			if (mid.w > dists[mid.y])
				continue;

			// dest 가 처리되어 있는지 확인
			// 현재 dist[dest] 보다 (dist[mid] + 해당 가중치)가 작다면 현재 값 으로 update
			for (Node dest : list.get(mid.y)) {
				if (dists[mid.y] + dest.w < dists[dest.y]) {
					dists[dest.y] = dists[mid.y] + dest.w;
					q.offer(new Node(dest.y, dists[mid.y] + dest.w));
				}
			}
		}
	}
}

class Node {
	int y, w;

	public Node(int y, int w) {
		this.y = y;
		this.w = w;
	}
}