import java.util.*;
import java.io.*;

public class Main {

	static List<List<Integer>> list = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<Integer>();

	static int[] indegree;
	static int[] times;
	static int[] totalTimes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());

		times = new int[size + 1];
		totalTimes = new int[size + 1];
		indegree = new int[size + 1];

		for (int i = 0; i < size + 1; i++)
			list.add(new ArrayList<>());

		for (int i = 1; i < size + 1; i++) {
			st = new StringTokenizer(br.readLine());

			if (st.countTokens() >= 3) {
				int v = Integer.parseInt(st.nextToken());
				times[i] = v;
				
				int nidx = 0;
				while ((nidx = Integer.parseInt(st.nextToken())) != -1) {
					list.get(nidx).add(i);
					indegree[i]++;
				}
			} else {
				times[i] = Integer.parseInt(st.nextToken());
				q.offer(i);
			}
		}
		
		ts();

		for (int i = 0; i < times.length; i++)
			totalTimes[i] += times[i];

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < totalTimes.length; i++)
			sb.append(totalTimes[i]).append("\n");

		System.out.println(sb.toString());
	}

	public static void ts() {
		while (!q.isEmpty()) {
			int n = q.poll();

			for (int next : list.get(n)) {
				indegree[next]--;
				
				totalTimes[next] = Math.max(totalTimes[next], totalTimes[n] + times[n]);
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}
