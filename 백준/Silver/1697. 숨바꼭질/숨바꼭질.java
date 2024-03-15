import java.io.*;
import java.util.*;

public class Main {

	static boolean[] v = new boolean[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		System.out.println(bfs(s, e));
	}

	static int bfs(int s, int e) {
		Queue<Time> q = new LinkedList<>();

		q.offer(new Time(s, 0));
		v[s] = true;

		while (!q.isEmpty()) {
			Time t = q.poll();

			if (t.loc == e) {
				return t.time;
			}

			for (int i = 0; i < 3; i++) {
				int temp = 0;
				if (i == 0) {
					temp = t.loc - 1;
				} else if (i == 1) {
					temp = t.loc + 1;
				} else
					temp = t.loc * 2;

				if (!(temp >= 0 && temp <= 100_000)) {
					continue;
				}

				if (v[temp])
					continue;

				v[temp] = true;
				q.offer(new Time(temp, t.time + 1));
			}
		}
		return 0;
	}

	static class Time {
		int loc, time;

		public Time(int loc, int time) {
			this.loc = loc;
			this.time = time;
		}
	}

}
