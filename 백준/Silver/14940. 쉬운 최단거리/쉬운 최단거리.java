import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		arr = new int[row][col];

		Node start = new Node(0, 0, 0);
		;

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1)
					arr[i][j] = -5;
				else if (n == 0) {
					arr[i][j] = -3;
				} else if (n == 2) {
					start = new Node(i, j, 0);
				}
			}
		}

		bfs(start);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == -5)
					sb.append(-1).append(" ");
				else if (arr[i][j] == -3)
					sb.append(0).append(" ");
				else
					sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(Node start) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(start);
		arr[start.x][start.y] = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
					if (arr[nx][ny] == -5) {
						arr[nx][ny] = n.dist + 1;
						q.offer(new Node(nx, ny, n.dist + 1));
					}
				}
			}
		}
	}

	static class Node {
		int x, y, dist;

		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}
