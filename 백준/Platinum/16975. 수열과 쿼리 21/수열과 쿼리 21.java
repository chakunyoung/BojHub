import java.util.*;
import java.io.*;

public class Main {

	static long[] arr;
	static long[] tree;
	static long[] lazy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		arr = new long[n + 1];
		tree = new long[(n + 1) * 4];
		lazy = new long[(n + 1) * 4];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = Long.parseLong(st.nextToken());
		build(1, n, 1);

		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int type = Integer.parseInt(st.nextToken());

			if (type == 1) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				long val = Long.parseLong(st.nextToken());
				updateRange(1, n, s, e, 1, val);
			} else if (type == 2) {
				int idx = Integer.parseInt(st.nextToken());
				sb.append(query(1, n, idx, idx, 1)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static public void build(int s, int e, int segIdx) {
		if (s == e) {
			tree[segIdx] = arr[s];
			return;
		}

		int mid = (s + e) >> 1;
		build(s, mid, segIdx << 1);
		build(mid + 1, e, segIdx << 1 | 1);
		tree[segIdx] = tree[segIdx << 1] + tree[segIdx << 1 | 1];
	}

	static public void propagation(int s, int e, int segIdx) {
		if (lazy[segIdx] != 0) {
			tree[segIdx] += (e - s + 1) * lazy[segIdx];

			if (s != e) {
				lazy[segIdx << 1] += lazy[segIdx];
				lazy[segIdx << 1 | 1] += lazy[segIdx];
			}
			lazy[segIdx] = 0;
		}
	}

	static public void updateRange(int s, int e, int qs, int qe, int segIdx, long value) {
		propagation(s, e, segIdx);

		if (qe < s || e < qs)
			return;

		if (qs <= s && e <= qe) {
			tree[segIdx] += (e - s + 1) * value;

			if (s != e) {
				lazy[segIdx << 1] += value;
				lazy[segIdx << 1 | 1] += value;
			}
			return;
		}

		int mid = (s + e) >> 1;
		updateRange(s, mid, qs, qe, segIdx << 1, value);
		updateRange(mid + 1, e, qs, qe, segIdx << 1 | 1, value);
		tree[segIdx] = tree[segIdx << 1] + tree[segIdx << 1 | 1];
	}

	static public long query(int s, int e, int qs, int qe, int segIdx) {
		propagation(s, e, segIdx);

		if (qe < s || e < qs)
			return 0;

		if (qs <= s && e <= qe)
			return tree[segIdx];

		int mid = (s + e) >> 1;
		return query(s, mid, qs, qe, segIdx << 1) + query(mid + 1, e, qs, qe, segIdx << 1 | 1);
	}

}
