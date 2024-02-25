import java.io.*;
import java.util.*;

public class Main {
	static int size;
	static int[] dist;
	static int[] track;
	static List<List<Node>> list = new ArrayList<>();
	static int count = 0;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		size = Integer.parseInt(br.readLine()) + 1;
		dist = new int[size];
		track = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(track, -1);

		int line = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.get(s).add(new Node(e, w));
		}

		st = new StringTokenizer(br.readLine());
		int ss = Integer.parseInt(st.nextToken());
		int ee = Integer.parseInt(st.nextToken());
		dist[ss] = 0;

		dijk(ss);
		int min = dist[ee];

		// System.out.println(Arrays.toString(track));

		System.out.println(min);
		tracking(ee);
		System.out.println(count);
		System.out.println(sb);

	}

	static void dijk(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.w - o2.w;
		});

		pq.offer(new Node(s, 0));

		while (!pq.isEmpty()) {
			Node mid = pq.poll();

			if (mid.w > dist[mid.dest])
				continue;

			List<Node> mids = list.get(mid.dest);

			for (Node n : mids) {
				int nw = dist[mid.dest] + n.w;
				if (dist[mid.dest] + n.w < dist[n.dest]) {
					dist[n.dest] = nw;
					pq.offer(new Node(n.dest, nw));
					track[n.dest] = mid.dest;
				}
			}
		}
	}

	static void tracking(int node) {
		if (track[node] != -1) {
			tracking(track[node]);
		}
		++count;
		sb.append(node).append(" ");
	}

	static class Node {
		int dest, w;

		public Node(int dest, int w) {
			this.dest = dest;
			this.w = w;
		}
	}
}
