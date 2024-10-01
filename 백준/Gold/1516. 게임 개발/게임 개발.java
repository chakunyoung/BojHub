import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> list = new ArrayList<>();
	static int[] indegree;
	static int[] time;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		indegree = new int[n + 1];
		time = new int[n + 1];
		ans = new int[n + 1];
		list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			ans[i] = time[i];

			while (true) {
				int build = Integer.parseInt(st.nextToken());
				if (build == -1)
					break;

				list.get(build).add(i);
				indegree[i]++;
			}
		}

		ts(n);

		for (int i = 1; i <= n; i++)
			sb.append(ans[i]).append("\n");

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

			for (int next : list.get(c)) {
				indegree[next]--;
				ans[next] = Math.max(ans[next], ans[c] + time[next]); // 다 지어져야 함

				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}
