import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int now = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		boolean[] v = new boolean[size + 1];

		Queue<Move> q = new LinkedList<>();
		q.offer(new Move(now, 0));

		int ans = -1;
		while (!q.isEmpty()) {
			Move m = q.poll();
			if (m.n < 1 || m.n > size)
				continue;

			if (v[m.n])
				continue;

			v[m.n] = true;

			if (m.n == target)
				ans = m.count;

			q.offer(new Move(m.n + u, m.count + 1));
			q.offer(new Move(m.n - d, m.count + 1));
		}

		System.out.println(ans == -1 ? "use the stairs" : ans);
	}

	static class Move {
		int count;
		int n;

		public Move(int n, int count) {
			this.n = n;
			this.count = count;
		}
	}
}
