import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		PriorityQueue<Node> maxQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Node> minQ = new PriorityQueue<>();

		for (int i = 0; i < testCase; i++) {
			int order = Integer.parseInt(br.readLine());

			while (order-- > 0) {
				st = new StringTokenizer(br.readLine());
				String o = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (o.equals("I")) {
					Node n = new Node(num);
					maxQ.add(n);
					minQ.add(n);

				} else {
					if (num == 1) { // max poll
						while (!maxQ.isEmpty()) {
							Node mn = maxQ.poll();
							if (!mn.isUsed) {
								mn.isUsed = true;
								break;
							}
						}
					} else { // min poll
						while (!minQ.isEmpty()) {
							Node mn = minQ.poll();
							if (!mn.isUsed) {
								mn.isUsed = true;
								break;
							}
						}
					}
				}
			}

			// 출력
			long[] ans = new long[2];
			boolean check = false;

			while (!maxQ.isEmpty()) {
				Node mn = maxQ.peek();
				if (!mn.isUsed) {
					ans[0] = mn.value;
					check = true;
					break;
				} else {
					maxQ.poll();
				}
			}
			while (!minQ.isEmpty()) {
				Node mn = minQ.peek();
				if (!mn.isUsed) {
					ans[1] = mn.value;
					break;
				} else {
					minQ.poll();
				}
			}
			if (check)
				sb.append(ans[0] + " " + ans[1]).append("\n");
			else
				sb.append("EMPTY").append("\n");

			minQ.clear();
			maxQ.clear();
		} // end tc
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {
		long value;
		boolean isUsed;

		public Node(long value) {
			this.value = value;
			this.isUsed = false;
		}

		@Override
		public int compareTo(Node o) {
			if (this.value <= o.value)
				return -1;
			else
				return 1;
		}
	}
}