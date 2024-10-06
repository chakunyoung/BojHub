import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dist = new int[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		dijk();

		System.out.println(dist[n - 1][n - 1]);
	}

	public static void dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
		pq.add(new Node(0, 0, 0));
		dist[0][0] = 0;

		while (!pq.isEmpty()) {
			Node c = pq.poll();

			if (c.w > dist[c.x][c.y])
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					int new1 = c.w + (arr[nx][ny] == 0 ? 1 : 0);

					if (new1 < dist[nx][ny]) {
						dist[nx][ny] = new1;
						pq.add(new Node(nx, ny, new1));
					}
				}
			}
		}
	}

	static class Node {
		int x, y, w;

		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.w = dist;
		}
	}

	static int n;
	static int[][] arr;
	static int[][] dist;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
}
