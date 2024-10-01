import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> list = new ArrayList<>();
	static int[] indegree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		indegree = new int[n + 1];
		list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			indegree[b]++;
		}

		ts(n);
		System.out.println(sb.toString());

	}

	static void ts(int n) {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int c = q.poll();
			sb.append(c).append(" ");

			for (int ele : list.get(c)) {
				indegree[ele]--;

				if (indegree[ele] == 0) {
					q.offer(ele);
				}
			}
		}
	}
}
