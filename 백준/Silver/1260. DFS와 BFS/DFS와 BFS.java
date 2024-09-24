import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int node = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		v = new boolean[node];

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < node; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			List<Integer> innerList = list.get(j - 1);
			innerList.add(k - 1);
			innerList = list.get(k - 1);
			innerList.add(j - 1);
		}

		for (int i = 0; i < list.size(); i++) {
			List<Integer> innerList = list.get(i);
			Collections.sort(innerList);
		}

		dfs(list, s - 1);
		sb.append("\n");
		Arrays.fill(v, false);
		bfs(list, s - 1);
		System.out.println(sb.toString());

	}

	static void dfs(List<List<Integer>> list, int node) {
		v[node] = true;
		sb.append(node + 1 + " ");
		List<Integer> innerList = list.get(node);

		for (int i = 0; i < innerList.size(); i++) {
			int n = innerList.get(i);
			if (!v[n]) {
				dfs(list, n);
			}
		}
	}

	static void bfs(List<List<Integer>> list, int node) {
		Queue<Integer> q = new LinkedList<>();
		v[node] = true;
		q.offer(node);

		while (!q.isEmpty()) {
			int n = q.poll();
			sb.append(n + 1 + " ");
			List<Integer> innerList = list.get(n);

			for (int i = 0; i < innerList.size(); i++) {
				int ele = innerList.get(i);
				if (!v[ele]) {
					v[ele] = true;
					q.offer(ele);
				}
			}
		}
	}
}