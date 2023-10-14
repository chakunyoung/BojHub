import java.util.*;
import java.io.*;

public class Main {

	static long[] arr;
	static long[] tree;
	static long[] lazy;

	static PriorityQueue<QueryClass> pq = new PriorityQueue<>((o1, o2) -> {
		return o1.line - o2.line;
	});

	static List<UpdateClass> updatelist = new ArrayList<>();

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
			arr[i] = Integer.parseInt(st.nextToken());

		build(1, n, 1);

		// update 1 query 2
		int line = Integer.parseInt(br.readLine());

		int queryIdx = 0;
		while (line-- > 0) {
			st = new StringTokenizer(br.readLine());

			int type = Integer.parseInt(st.nextToken());
			if (type == 1) {
				int idx = Integer.parseInt(st.nextToken());
				long value = Integer.parseInt(st.nextToken());
				updatelist.add(new UpdateClass(idx, value));
			} else if (type == 2) {
				int k = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				pq.offer(new QueryClass(k, s, e, queryIdx++));
			}
		}

		long[] queryArr = new long[queryIdx];

		int count = 0;
		for (int i = 0; i <= updatelist.size(); i++) {
			while (!pq.isEmpty() && pq.peek().line == count) {
				QueryClass peek = pq.peek();
				long sum = (query(1, n, peek.s, peek.e, 1));
				queryArr[peek.idx] = sum;
				pq.poll();
			}

			if (i == updatelist.size())
				break;

			UpdateClass updateClass = updatelist.get(i);
			update(1, n, updateClass.idx, updateClass.idx, 1, updateClass.value);
			++count;

			//System.out.println(Arrays.toString(queryArr));

		}
		for (long nn : queryArr) {
			sb.append(nn).append("\n");
		}
		System.out.println(sb);
	}

	public static void build(int s, int e, int segIdx) {
		if (s == e) {
			tree[segIdx] = arr[s];
			return;
		}

		int mid = (s + e) >> 1;
		build(s, mid, segIdx << 1);
		build(mid + 1, e, segIdx << 1 | 1);
		tree[segIdx] = tree[segIdx << 1] + tree[segIdx << 1 | 1];

	}

	// public static void propagation(int s, int e, int segIdx) {
	// 	if (lazy[segIdx] != 0) {
	// 		tree[segIdx] += (e - s + 1) * lazy[segIdx];
	// 		if (s != e) {
	// 			lazy[segIdx << 1] += lazy[segIdx];
	// 			lazy[segIdx << 1 | 1] += lazy[segIdx];
	// 		}
	// 		lazy[segIdx] = 0;
	// 	}
	// }

	public static void update(int s, int e, int qs, int qe, int segIdx, long value) {
		//propagation(s, e, segIdx);

		if (qe < s || e < qs)
			return;

		if(s == e){
			tree[segIdx] = value;
			return;
		}
		// if (qs <= s && e <= qe) {
		// 	tree[segIdx] += (e - s + 1) * value;
		// 	tree[segIdx] += (e - s + 1) * value;
		// 	if (s != e) {
		// 		lazy[segIdx << 1] += value;
		// 		lazy[segIdx << 1 | 1] += value;
		// 	}
		// 	return;
		// }

		int mid = (s + e) >> 1;
		update(s, mid, qs, qe, segIdx << 1, value);
		update(mid + 1, e, qs, qe, segIdx << 1 | 1, value);
		tree[segIdx] = tree[segIdx << 1] + tree[segIdx << 1 | 1];
	}

	public static long query(int s, int e, int qs, int qe, int segIdx) {
		//propagation(s, e, segIdx);

		if (qe < s || e < qs)
			return 0;

		if (qs <= s && e <= qe) {
			return tree[segIdx];
		}
		int mid = (s + e) >> 1;
		return query(s, mid, qs, qe, segIdx << 1) + query(mid + 1, e, qs, qe, segIdx << 1 | 1);
	}

	static class QueryClass {
		int line, s, e, idx;

		public QueryClass(int line, int s, int e, int idx) {
			this.line = line;
			this.s = s;
			this.e = e;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "QueryClass{" +
				"line=" + line +
				", s=" + s +
				", e=" + e +
				'}';
		}
	}

	static class UpdateClass {
		int idx;
		long value;

		public UpdateClass(int idx, long value) {
			this.idx = idx;
			this.value = value;
		}
	}
}
