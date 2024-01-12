import java.io.*;
import java.util.*;

public class Main {

	static boolean[] v;
	static int totalMoveLen;
	static List<List<Node>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int nodes = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		v = new boolean[nodes + 1];

		list = new ArrayList<>();
		for (int i = 0; i <= nodes; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < nodes - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			list.get(start).add(new Node(end, dist));
			list.get(end).add(new Node(start, dist));
		}

		int ans = bfs(s, e);
		System.out.println(ans);

	}

	public static int bfs(int s, int e) {
		Queue<Robot> q = new LinkedList<>();
		q.offer(new Robot(s, 0, 0));

		while (!q.isEmpty()) {
			Robot r = q.poll();

			if (r.start == e)
				return r.move - r.max;

			List<Node> forlist = list.get(r.start);

			for (Node n : forlist) {
				if (v[n.e])
					continue;
				v[n.e] = true;
				q.offer(new Robot(n.e, n.dist + r.move, Math.max(r.max, n.dist)));
			}
		}
		return 0;
	}

	static class Node {
		int e, dist;

		public Node(int e, int dist) {
			this.e = e;
			this.dist = dist;
		}
	}

	static class Robot {
		int start;
		int move;
		int max;

		public Robot(int start, int move, int max) {
			this.start = start;
			this.max = max;
			this.move = move;
		}
	}
}